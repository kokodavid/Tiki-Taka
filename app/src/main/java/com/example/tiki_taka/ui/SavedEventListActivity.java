package com.example.tiki_taka.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiki_taka.R;
import com.example.tiki_taka.adapters.FirebaseEventListAdapter;
import com.example.tiki_taka.adapters.FirebaseEventViewHolder;
import com.example.tiki_taka.util.OnStartDragListener;
import com.example.tiki_taka.util.SimpleItemTouchHelperCallback;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedEventListActivity extends AppCompatActivity implements OnStartDragListener {

    private DatabaseReference mEventReference;
    private FirebaseEventListAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;



    @BindView(R.id.recycler) RecyclerView RecyclerView;


/*
    RecyclerView RecyclerView;
*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_event_list);
        ButterKnife.bind(this);

        RecyclerView = findViewById(R.id.recycler);

        mEventReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_EVENTS);
        setUpFirebaseAdapter();

    }

/*
    private void setUpFirebaseAdapter() {
        FirebaseRecyclerOptions<Event> options =
                new FirebaseRecyclerOptions.Builder<Event>()
                        .setQuery(mEventReference, Event.class)
                        .build();

        mFirebaseAdapter = new FirebaseEventListAdapter(options, mEventReference, this, this);
        RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.setAdapter(mFirebaseAdapter);
        RecyclerView.setHasFixedSize(true);
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
        ItemTouchHelper = new ItemTouchHelper(callback);
        ItemTouchHelper.attachToRecyclerView(RecyclerView);
    }
*/

    private void setUpFirebaseAdapter(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        mEventReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_EVENTS).child(uid);
        FirebaseRecyclerOptions<Event> options =
                new FirebaseRecyclerOptions.Builder<Event>()
                        .setQuery(mEventReference, Event.class)
                        .build();

        mFirebaseAdapter = new FirebaseEventListAdapter(options, mEventReference, this, this);

        RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.setAdapter(mFirebaseAdapter);
        RecyclerView.setHasFixedSize(true);
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(RecyclerView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }
    public void onStartDrag(RecyclerView.ViewHolder viewHolder){
        mItemTouchHelper.startDrag(viewHolder);
    }
}