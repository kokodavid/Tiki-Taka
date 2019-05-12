package com.example.tiki_taka;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TicketActivity extends AppCompatActivity {

    private TextView mLocationTextView;
    private TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        mAppNameTextView = (TextView) findViewById(R.id.locationTextView);
           Typeface Windsong = Typeface.createFromAsset(getAssets(),"fonts/Amatic-Bold.ttf");
                    mAppNameTextView.setTypeface(Windsong);

          mLocationTextView = (TextView) findViewById(R.id.locationTextView);
                mLocationTextView.setText("You have successfully bought a ticket for the Event: " + location );
    }
    }

