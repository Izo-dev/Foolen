package com.waga.foolenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    MaterialButton mRegister;
    MaterialButton mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRegister = (MaterialButton) findViewById(R.id.register_button);
        mLogin = (MaterialButton) findViewById(R.id.login_button);
    }

    public void starRegister(View view) {

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void starLogin(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}