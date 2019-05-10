package com.example.tiki_taka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;

public class HomeActivity extends AppCompatActivity {



    @BindView(R.id.locationListView) ListView mListView;
    @BindView(R.id.locationTextView) TextView mLocationTextView;


    private String[] events = new String[]{
            "Na Iwake", "Color Splash", "kingKong pool Party", "Imax Avengers End Game", "Jameson party",
            "Mother's Day", "Mad run", "Nairobi Sunset Gt", "Nairobi Tech Week", "Matter heart run", "The Forest hike", "Etana Live in Kenya"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, events);
        mListView.setAdapter(adapter);
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

