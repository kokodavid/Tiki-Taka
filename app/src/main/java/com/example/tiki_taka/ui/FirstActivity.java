package com.example.tiki_taka.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiki_taka.R;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSearchEventButton;
    private static final int LENGTH_LONG = 3500; // 3.5 seconds
    private TextView textView4;
    private ImageView eventbrite;
    private ImageView hype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Typeface Windsong = Typeface.createFromAsset(getAssets(), "fonts/UnderType.ttf");
        textView4 = findViewById(R.id.textView4);
        textView4.setTypeface(Windsong);

        eventbrite = findViewById(R.id.eventbrite);
        eventbrite.setOnClickListener(this);

        hype = findViewById(R.id.hype);
        hype.setOnClickListener(this);

        mSearchEventButton = (Button) findViewById(R.id.SearchEvent);
        mSearchEventButton.setOnClickListener(this);
        {
        }


    }

    @Override
    public void onClick(View v) {
        if (v == mSearchEventButton) {
            Intent intent = new Intent(FirstActivity.this, HomeActivity.class);
            startActivity(intent);
            Toast.makeText(FirstActivity.this, "Searching Events", Toast.LENGTH_LONG).show();
        }
        if (v == eventbrite) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.eventbrite.com/d/kenya/events/"));
            startActivity(webIntent);
        }
        if (v == hype) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://twitter.com/hype_xp?lang=en"));
            startActivity(webIntent);
        }
    }
}

