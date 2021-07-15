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
import android.widget.Toast;

import com.google.android.gms.common.internal.Objects;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;

public class SignupActivity2 extends AppCompatActivity {
    //RadioButton mMradioBtn, mFradioBtn;
    RadioGroup mSex;
    RadioButton mRadioButton;
    DatePicker mDatePicker;
    Button mNextBtn, mLoginBtn;
    String mFullName, mUername, mEmail, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup2);
        mSex = findViewById(R.id.sex_id);
        mDatePicker = findViewById(R.id.signup_date_picker);
        mNextBtn = findViewById(R.id.signup_next_btn2);
        mLoginBtn = findViewById(R.id.signup_login_btn);
        Intent intent = getIntent();
        mFullName = intent.getStringExtra("fullName");
        mUername = intent.getStringExtra("userName");
        mEmail = intent.getStringExtra("email");
        mPassword = intent.getStringExtra("password");
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void goNextSignupScreen(View view) {
        Intent intent = new Intent(this, SignupActivity3.class);
        /*String mRadioBtn = mMradioBtn.getText().toString();
        String fRadioBtn = mFradioBtn.getText().toString();
        String sex = mSex.getAutofillValue().toString();*/
        int day = mDatePicker.getDayOfMonth();
        int month = mDatePicker.getMonth();
        int year = mDatePicker.getYear();
        String fullName = mFullName;
        String userName = mUername;
        String email = mEmail;
        String password = mPassword;
        //String sex = String.valueOf(mSex.getCheckedRadioButtonId());
        int mCheckId = mSex.getCheckedRadioButtonId();
        mRadioButton = findViewById(mCheckId);
        String date;
        if (day>9){
            date = day+"/"+month+"/"+year;
        }
        else {
            date = "0"+day+"/"+month+"/"+year;
        }
        intent.putExtra("fullName", fullName);
        intent.putExtra("userName", userName);
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        String sex = mRadioButton.getText().toString();
        intent.putExtra("sex", sex);
        intent.putExtra("date", date);
        Toast.makeText(this, "la date"+date, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "le nom"+fullName, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "l'email'"+email, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "le password"+password, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "le sexe"+sex, Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}
