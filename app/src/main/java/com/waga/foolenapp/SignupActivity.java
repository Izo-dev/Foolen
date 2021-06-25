package com.waga.foolenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    ImageView mSBackBtn;
    Button mSNextBtn, mSLoginBtn;
    TextView mSTtitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mSBackBtn = findViewById(R.id.signup_back_btn);
        mSNextBtn = findViewById(R.id.signup_next_btn);
        mSLoginBtn = findViewById(R.id.signup_login_btn);
        mSTtitleText =findViewById(R.id.signup_title_text);
    }

    public void goNextSignupScreen(View view) {

        Intent intent = new Intent(this, SignupActivity2.class);

        //Transition
        Pair pairs[] = new Pair[4];

        pairs[0] = new Pair<View, String>(mSBackBtn, "transition_back_btn");
        pairs[1] = new Pair<View, String>(mSTtitleText, "transition_signup_title");
        pairs[2] = new Pair<View, String>(mSNextBtn, "transition_next_btn");
        pairs[3] = new Pair<View, String>(mSLoginBtn, "transition_login_btn");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pairs);
            startActivity(intent, options.toBundle());
        }

        else {
            startActivity(intent);
        }

    }
}