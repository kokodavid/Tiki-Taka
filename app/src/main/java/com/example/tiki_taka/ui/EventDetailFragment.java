package com.example.tiki_taka.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiki_taka.R;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventDetailFragment extends Fragment {




    @BindView(R.id.eventImageView)ImageView eventImageView;
    @BindView(R.id.eventNameTextView) TextView mNameView;
    @BindView(R.id.eventDescriptionTextView) TextView mDescriptionView;
    @BindView(R.id.eventDateTextView) TextView mDateView;
    @BindView(R.id.eventDate2TextView) TextView mDate2View;

    private Event mEvent;

    public static EventDetailFragment newInstance(Event event) {
        EventDetailFragment eventDetailFragment = new EventDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("event", Parcels.wrap(event));
        eventDetailFragment.setArguments(args);
        return eventDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEvent = Parcels.unwrap(getArguments().getParcelable("event"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_detail, container, false);

        ButterKnife.bind(this, view);


        mNameView.setText(mEvent.getName());
        mDescriptionView.setText(mEvent.getDescription());
        mDateView.setText(mEvent.getStart());
        mDate2View.setText(mEvent.getEnd());


        return view;
    }
}