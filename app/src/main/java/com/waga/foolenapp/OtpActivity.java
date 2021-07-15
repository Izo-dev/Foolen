package com.waga.foolenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chaos.view.PinView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OtpActivity extends AppCompatActivity {

    Button mVerifBtn;
    PinView mPinview;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        mVerifBtn = findViewById(R.id.verif_btn);
        mPinview = findViewById(R.id.pin_views);
        //String phoneNumber = getIntent().getStringExtra("phone");
        //sendVerifCode(phoneNumber);
    }

    public void verifierCode(View view) {

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}