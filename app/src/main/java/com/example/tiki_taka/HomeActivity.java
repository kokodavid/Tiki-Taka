package com.example.tiki_taka;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class HomeActivity extends AppCompatActivity {

    private ArrayList<Event> mEvents = new ArrayList<>();

    private EventListAdapter mAdapter;

    //@BindView(R.id.recycler) RecyclerView mRecyclerView;
    RecyclerView mRecyclerView;

    private TextView mAppNameTextView;

    public static final String TAG = HomeActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ButterKnife.bind(this);

        mRecyclerView = findViewById(R.id.recycler);

        mAppNameTextView = (TextView) findViewById(R.id.locationTextView);
        Typeface Windsong = Typeface.createFromAsset(getAssets(), "fonts/Windsong.ttf");
        mAppNameTextView.setTypeface(Windsong);

        getEvents();


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
                    public void run () {
                        mAdapter = new EventListAdapter(getApplicationContext(), mEvents); 
                       mRecyclerView.setAdapter(mAdapter);
                        StaggeredGridLayoutManager gridLayoutManager =     new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL);
                        mRecyclerView.setLayoutManager(gridLayoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }

        });
    }
}





