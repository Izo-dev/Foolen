package com.waga.foolenapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;

public class SignupActivity2 extends AppCompatActivity {
    //RadioButton mMradioBtn, mFradioBtn;
    RadioGroup mSex;
    DatePicker mDatePicker;
    Button mSNextBtn, mSLoginBtn;
    String mSFullName, mSUername, mSEmail, mSPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup2);
        //mMradioBtn = findViewById(R.id.m_signup_radio);
        //mFradioBtn = findViewById(R.id.f_signup_radio);
        mSex = findViewById(R.id.sex_id);
        mDatePicker = findViewById(R.id.signup_date_picker);
        mSNextBtn = findViewById(R.id.signup_next_btn2);
        mSLoginBtn = findViewById(R.id.signup_login_btn);

        Intent intent = getIntent();
        mSFullName = intent.getStringExtra("fullName");
        mSUername = intent.getStringExtra("userName");
        mSEmail = intent.getStringExtra("email");
        mSPassword = intent.getStringExtra("password");

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void goNextSignupScreen(View view) {


        Intent intent = new Intent(this, SignupActivity3.class);
        /*String mRadioBtn = mMradioBtn.getText().toString();
        String fRadioBtn = mFradioBtn.getText().toString();*/
        String sex = mSex.getAutofillValue().toString();
        String datePicker = String.valueOf(mDatePicker.getAutofillValue().getDateValue());
        intent.putExtra("fullname", mSFullName);
        intent.putExtra("username", mSUername);
        intent.putExtra("email", mSEmail);
        intent.putExtra("password", mSPassword);
        /*intent.putExtra("mradio", mRadioBtn);
        intent.putExtra("fradio", fRadioBtn);*/
        intent.putExtra("sex", sex);
        intent.putExtra("date", datePicker);

        startActivity(intent);
    }
}