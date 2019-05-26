package com.example.tiki_taka.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.tiki_taka.R;
import com.example.tiki_taka.ui.Constants;
import com.example.tiki_taka.ui.Event;
import com.example.tiki_taka.ui.EventDetailActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseEventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;

    public FirebaseEventViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindEvents(Event events) {
        TextView nameTextView = (TextView) mView.findViewById(R.id.eventNameTextView);
        TextView descriptionTextView = (TextView) mView.findViewById(R.id.eventDescriptionTextView);
        TextView startTextView = (TextView) mView.findViewById(R.id.eventDateTextView);
        TextView endTextView = (TextView) mView.findViewById(R.id.eventDate2TextView);



    }

    @Override
    public void onClick(View v) {
        final ArrayList<Event> events = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_EVENTS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    events.add(snapshot.getValue(Event.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, EventDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("restaurants", Parcels.wrap(events));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


        }
}
