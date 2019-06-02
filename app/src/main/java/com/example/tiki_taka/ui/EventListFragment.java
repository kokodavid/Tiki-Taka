package com.example.tiki_taka.ui;


import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tiki_taka.R;
import com.example.tiki_taka.adapters.EventListAdapter;
import com.example.tiki_taka.adapters.EventPagerAdapter;
import com.example.tiki_taka.services.EventBriteService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventListFragment extends Fragment {
    private ArrayList<Event> mEvents = new ArrayList<>();

    private EventListAdapter mAdapter;


/*
    RecyclerView mRecyclerView;
*/

    /*private TextView mAppNameTextView;*/

    public static final String TAG = HomeActivity.class.getSimpleName();


    private ViewPager mViewPager;
    private EventPagerAdapter adapterViewPager;
    ArrayList<Event> mEvent = new ArrayList<>();
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    @BindView(R.id.locationTextView)
    RecyclerView mAppNameTextView;


    public EventListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*
        mRecyclerView = findViewById(R.id.recycler);
*/
/*
        mAppNameTextView = (TextView) findViewById(R.id.locationTextView);
*/
/*
        Typeface Windsong = Typeface.createFromAsset(getAssets(), "fonts/Amatic-Bold.ttf");
*/


        getEvents();

        // Instructs fragment to include menu options:
        setHasOptionsMenu(true);
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
                getActivity().runOnUiThread(new Runnable() {


                    @Override
                    public void run() {
                        mAdapter = new EventListAdapter(getActivity(), mEvents);

                        mRecyclerView.setAdapter(mAdapter);

                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }

        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);
        ButterKnife.bind(this, view);


        return view;
        // Inflate the layout for this fragment}

    }
}
