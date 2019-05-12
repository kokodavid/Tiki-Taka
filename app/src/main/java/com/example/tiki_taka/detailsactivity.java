package com.example.tiki_taka;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;

public class detailsactivity extends AppCompatActivity {


            TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsactivity);




        textView = (TextView)findViewById(R.id.txtitem);
        String Tempholder = getIntent().getStringExtra("Listviewclickvalue" );
        textView.setText(Tempholder);

    }
}
