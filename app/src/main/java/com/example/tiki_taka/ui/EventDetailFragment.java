package com.example.tiki_taka.ui;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiki_taka.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventDetailFragment extends Fragment implements View.OnClickListener {

    private static final int REQUEST_IMAGE_CAPTURE = 111;


    @BindView(R.id.eventImageView)
    ImageView eventImageView;
    @BindView(R.id.eventNameTextView)
    TextView mNameView;
    @BindView(R.id.eventDescriptionTextView)
    TextView mDescriptionView;
    @BindView(R.id.eventDateTextView)
    TextView mDateView;
    @BindView(R.id.eventDate2TextView)
    TextView mDate2View;
    @BindView(R.id.save)
    ImageView mSave;

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
        setHasOptionsMenu(true);

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
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();

            DatabaseReference eventRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_EVENTS)
                    .child(uid);

            DatabaseReference pushRef = eventRef.push();
            String pushId = pushRef.getKey();
            mEvent.setPushId(pushId);
            pushRef.setValue(mEvent);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
            inflater.inflate(R.menu.menu_photo, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.photo:
                onLaunchCamera();
            default:
                break;
        }
        return false;
    }
    public void onLaunchCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public static Bitmap decodeFromFirebaseBase64(String image) throws IOException {
        byte[] decodedByteArray = android.util.Base64.decode(image, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.length);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == getActivity().RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

        }
    }
}
