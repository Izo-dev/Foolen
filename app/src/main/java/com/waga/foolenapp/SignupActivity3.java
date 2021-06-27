package com.waga.foolenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class SignupActivity3 extends AppCompatActivity {

    CountryCodePicker mCountryCodePicker;
    TextInputLayout mPhone;
    String mFullName, mUserName, mEmail, mPassword, mSex, mDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup3);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mCountryCodePicker = findViewById(R.id.country_code_holder);
        mPhone = findViewById(R.id.signup_phone);

        Intent intent = getIntent();
        mFullName = intent.getStringExtra("fullname");
        mUserName = intent.getStringExtra("username");
        mEmail = intent.getStringExtra("email");
        mPassword = intent.getStringExtra("password");
        mSex = intent.getStringExtra("sex");
        mDate = intent.getStringExtra("date");

    }

    public void goNextSignupScreen(View view) {

        //Validation

        Intent intent = new Intent(this, OtpActivity.class);

        intent.putExtra("fullname", mFullName);
        intent.putExtra("username", mUserName);
        intent.putExtra("email", mEmail);
        intent.putExtra("password", mPassword);
        intent.putExtra("sex", mSex);
        intent.putExtra("date", mDate);
        String countryCodePicker = mCountryCodePicker.getSelectedCountryCodeWithPlus().toString();
        intent.putExtra("code", countryCodePicker);
        String phone = mPhone.getEditText().getText().toString();
        intent.putExtra("phone", phone);
        Toast.makeText(this, "infos"+intent, Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}