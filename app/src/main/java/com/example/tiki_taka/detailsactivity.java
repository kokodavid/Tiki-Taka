package com.example.tiki_taka;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;

public class detailsactivity extends AppCompatActivity {

    private TextView mLocationTextView;
    private Button mBuyTicketButton;
    private EditText mLocationEditText;
            TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsactivity);


        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
        mLocationTextView = (TextView) findViewById(R.id.locationTextView);


        textView = (TextView)findViewById(R.id.txtitem);
        String Tempholder = getIntent().getStringExtra("Listviewclickvalue" );
        textView.setText(Tempholder);

        mBuyTicketButton = (Button) findViewById(R.id.buyTicketButton);
        mBuyTicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = mLocationEditText.getText().toString();
                Intent intent = new Intent(detailsactivity.this, TicketActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
    }
}
