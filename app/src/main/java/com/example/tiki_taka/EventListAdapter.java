package com.example.tiki_taka;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


import butterknife.BindView;
import butterknife.ButterKnife;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder> {


    private ArrayList<Event> mEvents = new ArrayList<>();
    private Context mContext;

    public EventListAdapter(Context context, ArrayList<Event>events){
        mContext = context;
        mEvents = events;
    }

    @Override
    public EventListAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item, parent, false);
        EventViewHolder viewHolder = new EventViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventListAdapter.EventViewHolder holder, int position) {
        holder.bindEvents(mEvents.get(position));
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public  class EventViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.eventImageView)ImageView eventImageView;
        @BindView(R.id.eventNameTextView) TextView mNameView;
        @BindView(R.id.eventDescriptionTextView) TextView mDescriptionView;
        @BindView(R.id.eventDateTextView) TextView mDateView;
        @BindView(R.id.eventDate2TextView) TextView mDate2View;



        private Context mContext;

        public EventViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindEvents(Event events) {
            mNameView.setText(events.getName());
            mDescriptionView.setText(events.getDescription());
            mDateView.setText(events.getStart());
            mDate2View.setText(events.getEnd());




        }


    }
}
