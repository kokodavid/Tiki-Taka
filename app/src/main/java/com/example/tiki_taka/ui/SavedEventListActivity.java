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
import com.google.firebase.database.Query;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedEventListActivity extends AppCompatActivity  {


/*
    RecyclerView RecyclerView;
*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_event_list);
       /* ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mEventReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_EVENTS).child(uid);
        setUpFirebaseAdapter();*/
    }







    }

