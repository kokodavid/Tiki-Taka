package com.example.tiki_taka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;

public class detailsactivity extends AppCompatActivity {


    @BindView(R.id.txtitem) TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsactivity);



        String Tempholder = getIntent().getStringExtra("Listviewclickvalue");

        textView.setText(Tempholder);

    }
}
