package com.example.tiki_taka.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tiki_taka.R;

public class FirstActivity extends AppCompatActivity {

    private Button mSearchEventButton;
    private static final int LENGTH_LONG  = 3500; // 3.5 seconds



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        mSearchEventButton = (Button) findViewById(R.id.SearchEvent);
        mSearchEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, HomeActivity.class);
                startActivity(intent);
                Toast.makeText(FirstActivity.this, "Searching Events", Toast.LENGTH_LONG).show();

            }
        });
    }
}
