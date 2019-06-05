package com.example.tiki_taka.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiki_taka.R;
import com.example.tiki_taka.adapters.FirebaseEventListAdapter;
import com.example.tiki_taka.util.OnStartDragListener;
import com.example.tiki_taka.util.SimpleItemTouchHelperCallback;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedEventsListFragment extends Fragment implements OnStartDragListener {

    private DatabaseReference mEventReference;
    private FirebaseEventListAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;



    @BindView(R.id.recycler)
    android.support.v7.widget.RecyclerView RecyclerView;

    public SavedEventsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved_events_list, container, false);
        ButterKnife.bind(this, view);
        setUpFirebaseAdapter();
        return view;
    }


    private void setUpFirebaseAdapter() {
        {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();


            Query query = FirebaseDatabase.getInstance()
                    .getReference(Constants.FIREBASE_CHILD_EVENTS)
                    .child(uid)
                    .orderByChild(Constants.FIREBASE_QUERY_INDEX);

            mEventReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_EVENTS).child(uid);
            FirebaseRecyclerOptions<Event> options =
                    new FirebaseRecyclerOptions.Builder<Event>()
                            .setQuery(mEventReference, Event.class)
                            .build();


            mFirebaseAdapter = new FirebaseEventListAdapter(options, mEventReference, this, getActivity());

            RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            RecyclerView.setAdapter(mFirebaseAdapter);
            RecyclerView.setHasFixedSize(true);

            mFirebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                @Override
                public void onItemRangeInserted(int positionStart, int itemCount) {
                    super.onItemRangeInserted(positionStart, itemCount);
                    mFirebaseAdapter.notifyDataSetChanged();
                }
            });

            ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
            mItemTouchHelper = new ItemTouchHelper(callback);
            mItemTouchHelper.attachToRecyclerView(RecyclerView);
        }
    }


    public void onStartDrag(RecyclerView.ViewHolder viewHolder){
        mItemTouchHelper.startDrag(viewHolder);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.stopListening(); }


    @Override
    public void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
}


}
