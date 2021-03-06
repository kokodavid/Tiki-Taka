package com.example.tiki_taka.adapters;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiki_taka.R;
import com.example.tiki_taka.ui.Constants;
import com.example.tiki_taka.ui.Event;
import com.example.tiki_taka.ui.EventDetailActivity;
import com.example.tiki_taka.util.ItemTouchHelperViewHolder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseEventViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
    public ImageView mImageView;

    View mView;
    Context mContext;

    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    public FirebaseEventViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindEvents(Event events) {
        mImageView = (ImageView) mView.findViewById(R.id.eventImageView);
        TextView nameTextView = (TextView) mView.findViewById(R.id.eventNameTextView);
        TextView descriptionTextView = (TextView) mView.findViewById(R.id.eventDescriptionTextView);
        TextView startTextView = (TextView) mView.findViewById(R.id.eventDateTextView);
        TextView endTextView = (TextView) mView.findViewById(R.id.eventDate2TextView);
        nameTextView.setText(events.getName());
        descriptionTextView.setText(events.getDescription());
        startTextView.setText(events.getStart());
        endTextView.setText(events.getEnd());


    }


    @Override
    public void onItemSelected() {
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,
                R.animator.drag_scale_on);
        set.setTarget(itemView);
        set.start();
    }

    @Override
    public void onItemClear() {
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,
                R.animator.drag_scale_off);
        set.setTarget(itemView);
        set.start();

    }
    }

