package com.waga.foolenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class SignupActivity2 extends AppCompatActivity {

    Button mSNextBtn, mSLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup2);
        mSNextBtn = findViewById(R.id.signup_next_btn2);
        mSLoginBtn = findViewById(R.id.signup_login_btn);
    }

    public void goNextSignupScreen(View view) {
        Intent intent = new Intent(this, SignupActivity3.class);
        startActivity(intent);
    }
}