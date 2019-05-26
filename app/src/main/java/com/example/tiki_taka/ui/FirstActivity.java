package com.example.tiki_taka.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiki_taka.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mSearchEventButton;
    private static final int LENGTH_LONG = 3500; // 3.5 seconds
    private TextView textView4;
    private ImageView eventbrite;
    private ImageView hype;
    private ImageView hbr;
    private TextView mCreateEvent;
    private ImageView mosound;
    private ImageView nrg;
    private ImageView hapakenya;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private TextView mSaved;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Typeface Windsong = Typeface.createFromAsset(getAssets(), "fonts/UnderType.ttf");
        textView4 = findViewById(R.id.textView4);
        textView4.setTypeface(Windsong);

        mSaved = findViewById(R.id.save);
        mSaved.setOnClickListener(this);


        eventbrite = findViewById(R.id.eventbrite);
        eventbrite.setOnClickListener(this);

        hype = findViewById(R.id.hype);
        hype.setOnClickListener(this);

        hbr = findViewById(R.id.hbr);
        hbr.setOnClickListener(this);

        mosound = findViewById(R.id.mosound);
        mosound.setOnClickListener(this);

        nrg = findViewById(R.id.nrg);
        nrg.setOnClickListener(this);

        hapakenya = findViewById(R.id.hapakenya);
        hapakenya.setOnClickListener(this);

        mCreateEvent = (TextView) findViewById(R.id.create);
        mCreateEvent.setOnClickListener(this);


        mSearchEventButton = (TextView) findViewById(R.id.SearchEvent);
        mSearchEventButton.setOnClickListener(this);
        {
        }

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    getSupportActionBar().setTitle("Welcome, " + user.getDisplayName() + "user");
                } else {

                }            }
        };



    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;

        }


            return super.onOptionsItemSelected(item);
        }

        private void logout () {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(FirstActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }






    @Override
    public void onClick(View v) {
        if (v == mSearchEventButton) {
            Intent intent = new Intent(FirstActivity.this, HomeActivity.class);
            startActivity(intent);
            Toast.makeText(FirstActivity.this, "Searching Events", Toast.LENGTH_LONG).show();
        }
        if (v ==  mCreateEvent) {
            Intent intent = new Intent(FirstActivity.this, detailsactivity.class);
            startActivity(intent);
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

        if (v == hbr) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://hbr.co.ke/test/category/events/"));
            startActivity(webIntent);
        }

        if (v == mosound) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.mosound.co.ke/home/"));
            startActivity(webIntent);
        }

        if (v == nrg) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://nrg.radio/events-archive/"));
            startActivity(webIntent);
        }

        if (v == hapakenya) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://hapakenya.com/events/"));
            startActivity(webIntent);
        }
        if (v == mSaved) {
            Intent intent = new Intent(FirstActivity.this, SavedEventListActivity.class);
            startActivity(intent);
        }
    }


}

