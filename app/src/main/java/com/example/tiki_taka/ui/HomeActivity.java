package com.example.tiki_taka.ui;

import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import com.example.tiki_taka.adapters.EventListAdapter;
import com.example.tiki_taka.R;
import com.example.tiki_taka.adapters.EventPagerAdapter;
import com.example.tiki_taka.services.EventBriteService;

import org.parceler.Parcels;

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


    RecyclerView mRecyclerView;

    private TextView mAppNameTextView;

    public static final String TAG = HomeActivity.class.getSimpleName();


     private ViewPager mViewPager;
    private EventPagerAdapter adapterViewPager;
    ArrayList<Event> mEvent = new ArrayList<>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ButterKnife.bind(this);

        mRecyclerView = findViewById(R.id.recycler);
        mAppNameTextView = (TextView) findViewById(R.id.locationTextView);
        Typeface Windsong = Typeface.createFromAsset(getAssets(), "fonts/Amatic-Bold.ttf");
        /*mAppNameTextView.setTypeface(Windsong);*/

   /*    mEvent = Parcels.unwrap(getIntent().getParcelableExtra("events"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        mViewPager = findViewById(R.id.viewPager);
        adapterViewPager = new EventPagerAdapter(getSupportFragmentManager(), mEvent);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);*/


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

                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }

        });
    }
}





