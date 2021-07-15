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
        mFullName = intent.getStringExtra("fullName");
        mUserName = intent.getStringExtra("userName");
        mEmail = intent.getStringExtra("email");
        mPassword = intent.getStringExtra("password");
        mSex = intent.getStringExtra("sex");
        mDate = intent.getStringExtra("date");

    }

    public void goNextSignupScreen(View view) {

        //Validation

        Intent intent = new Intent(this, OtpActivity.class);
        String countryCodePicker = mCountryCodePicker.getFullNumberWithPlus().toString();
        String phone = mPhone.getEditText().getText().toString();
        String tel = countryCodePicker + phone;
        String fullName = mFullName;
        String userName = mUserName;
        String email = mEmail;
        String password = mPassword;
        String sex = mSex;
        String date = mDate;
        intent.putExtra("fullname", fullName);
        intent.putExtra("username", userName);
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        intent.putExtra("sex", sex);
        intent.putExtra("date", date);
        intent.putExtra("phone", tel);
        Toast.makeText(this, "Fullname :"+fullName, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Username :"+userName, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Email :"+email, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Password :"+password, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Sex :"+sex, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Age :"+date, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Telephone :"+tel, Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}