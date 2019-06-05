package com.example.tiki_taka.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tiki_taka.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class detailsactivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mLocationTextView;
    private Button mCreate;
    private EditText mLocationEditText;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mEventsDatabaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsactivity);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mEventsDatabaseReference = mFirebaseDatabase.getReference().child("Events");

        mCreate = (Button) findViewById(R.id.create);
        mCreate.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}

