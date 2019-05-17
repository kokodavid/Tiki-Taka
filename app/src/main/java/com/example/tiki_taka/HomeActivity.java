package com.example.tiki_taka;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.graphics.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class HomeActivity extends AppCompatActivity {

    public static final String TAG = HomeActivity.class.getSimpleName();
    public ArrayList<Event> mEvents = new ArrayList<>();

    private ListView mListView;
    private TextView mAppNameTextView;
    private TextView mLocationTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getEvents();


        mAppNameTextView = (TextView) findViewById(R.id.locationTextView);
        Typeface Windsong = Typeface.createFromAsset(getAssets(), "fonts/Windsong.ttf");
        mAppNameTextView.setTypeface(Windsong);

        mLocationTextView = (TextView) findViewById(R.id.locationTextView);


    }

    private void getEvents() {
        final EventBriteService EventBriteService = new EventBriteService();
        EventBriteService.findEvents(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mEvents = EventBriteService.processResults(response);
                HomeActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        String[] eventsNames = new String[mEvents.size()];
                        for (int i = 0; i < eventsNames.length; i++) {
                            eventsNames[i] = mEvents.get(i).getName();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(HomeActivity.this,
                                android.R.layout.simple_list_item_1, eventsNames);
                        mListView.setAdapter(adapter);

                    }

                });
            }

        });
    }
}

