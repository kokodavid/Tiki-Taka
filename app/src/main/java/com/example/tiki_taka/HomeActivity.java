package com.example.tiki_taka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;

public class HomeActivity extends AppCompatActivity {

    private TextView mLocationTextView;
    private ListView mListView;


    private String[] events = new String[] {
            "Na Iwake", "Color Splash","kingKong pool Party", "Imax Avengers End Game", "Jameson party",
            "Mother's Day","Mad run","Nairobi Sunset Gt","Nairobi Tech Week","Matter heart run","The Forest hike","Etana Live in Kenya"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mListView = (ListView) findViewById(R.id.locationListView);
        mLocationTextView = (TextView) findViewById(R.id.locationTextView);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,events);
        mListView.setAdapter(adapter);


    }
}
