package com.example.tiki_taka;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;

public class HomeActivity extends AppCompatActivity {


    @BindView(R.id.locationTextView) TextView mLocationTextView;
    private ListView mListView;
    private TextView mAppNameTextView;


    private String[] events = new String[] {
            "Na Iwake", "Color Splash","kingKong pool Party", "Imax Avengers End Game", "Jameson party",
            "Mother's Day","Mad run","Nairobi Sunset Gt","Nairobi Tech Week","Matter heart run","The Forest hike","Etana Live in Kenya"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mListView = (ListView) findViewById(R.id.locationListView);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,events);
        mListView.setAdapter(adapter);

        mAppNameTextView = (TextView) findViewById(R.id.locationTextView);
        Typeface Windsong = Typeface.createFromAsset(getAssets(),"fonts/Windsong.ttf");
        mAppNameTextView.setTypeface(Windsong);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String Templistview = events[position].toString();
                Intent intent = new Intent(HomeActivity.this, detailsactivity.class);
                intent.putExtra("Listviewclickvalue", Templistview);
                startActivity(intent);
            }
        });

    }
}