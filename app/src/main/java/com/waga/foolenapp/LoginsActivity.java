package com.waga.foolenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class LoginsActivity extends AppCompatActivity {
    Button mLoginBtn, mSignupBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logins);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mLoginBtn = findViewById(R.id.login_lg_btn);
        mSignupBtn = findViewById(R.id.login_signup);
    }


    public void goDashboard(View view) {
        Intent intent = new Intent(this, HomeActivity.class);

        startActivity(intent);

    }

    public void goSignup(View view) {

        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
}
