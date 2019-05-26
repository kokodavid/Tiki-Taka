package com.example.tiki_taka.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiki_taka.R;
import com.example.tiki_taka.adapters.FirebaseEventViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedEventListActivity extends AppCompatActivity {

    private DatabaseReference mRestaurantReference;
    private FirebaseRecyclerAdapter<Event, FirebaseEventViewHolder> mFirebaseAdapter;


/*
    @BindView(R.id.recycler) RecyclerView RecyclerView;
*/

    RecyclerView RecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_event_list);
        ButterKnife.bind(this);

        RecyclerView = findViewById(R.id.recycler);

        mRestaurantReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_EVENTS);
        setUpFirebaseAdapter();

    }

    private void setUpFirebaseAdapter() {
        FirebaseRecyclerOptions<Event> options =
                new FirebaseRecyclerOptions.Builder<Event>()
                        .setQuery(mRestaurantReference, Event.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Event, FirebaseEventViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseEventViewHolder firebaseEventViewHolder, int position, @NonNull Event event) {
                firebaseEventViewHolder.bindEvents(event);
            }

            @NonNull
            @Override
            public FirebaseEventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item, parent, false);
                return new FirebaseEventViewHolder(view);
            }
        };

        RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mFirebaseAdapter != null) {
            mFirebaseAdapter.stopListening();
        }
    }
}
