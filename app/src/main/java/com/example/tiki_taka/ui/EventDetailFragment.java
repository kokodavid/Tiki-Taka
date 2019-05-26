package com.example.tiki_taka.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiki_taka.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventDetailFragment extends Fragment implements View.OnClickListener {




    @BindView(R.id.eventImageView)ImageView eventImageView;
    @BindView(R.id.eventNameTextView) TextView mNameView;
    @BindView(R.id.eventDescriptionTextView) TextView mDescriptionView;
    @BindView(R.id.eventDateTextView) TextView mDateView;
    @BindView(R.id.eventDate2TextView) TextView mDate2View;
    @BindView(R.id.save) ImageView mSave;

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

        mSave.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mSave) {
            DatabaseReference eventRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_EVENTS);
            eventRef.push().setValue(mEvent);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}