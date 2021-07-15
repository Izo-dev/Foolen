package com.waga.foolenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    MaterialButton mRegister;
    MaterialButton mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mRegister = (MaterialButton) findViewById(R.id.register_button);
        mLogin = (MaterialButton) findViewById(R.id.login_button);
    }

    public void starRegister(View view) {

        Intent intent = new Intent(this, SignupActivity.class);

        /*Pair pairs[] = new Pair[1];
        pairs[0] = new Pair<View, String>(mRegister, "transition_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pairs);
            startActivity(intent, options.toBundle());
        }
        startActivity(intent);*/
        startActivity(intent);
    }

    public void starLogin(View view) {
        Intent intent = new Intent(this, LoginsActivity.class);

        startActivity(intent);
    }
}