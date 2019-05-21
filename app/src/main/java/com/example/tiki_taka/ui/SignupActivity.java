package com.example.tiki_taka.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiki_taka.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.login) TextView login;

    private Button signup;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        login.setOnClickListener(this);

        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == login) {

            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);

        } else if (v == signup) {
            Intent intent = new Intent(SignupActivity.this, FirstActivity.class);
            startActivity(intent);

        }
    }
}
