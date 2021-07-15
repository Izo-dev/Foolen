package com.waga.foolenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class SignupActivity extends AppCompatActivity {

    ImageView mSBackBtn;
    Button mSNextBtn, mSLoginBtn;
    TextView mSTitleText;

    TextInputLayout mFullName, mUserName, mEmail, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mSBackBtn = findViewById(R.id.signup_back_btn);
        mSNextBtn = findViewById(R.id.signup_next_btn);
        mSLoginBtn = findViewById(R.id.signup_login_btn);
        mSTitleText =findViewById(R.id.signup_title_text);

        //
        mFullName = findViewById(R.id.signup_fullname);
        mUserName = findViewById(R.id.signup_username);
        mEmail = findViewById(R.id.signup_email);
        mPassword = findViewById(R.id.signup_password);
    }

    public void goNextSignupScreen(View view) {

        if (!validateFullname() | !validateUsername() | !validateEmail()){
            return;
        }
        String fullName = mFullName.getEditText().getText().toString();
        String userName = mUserName.getEditText().getText().toString();
        String email = mEmail.getEditText().getText().toString();
        String password = mPassword.getEditText().getText().toString();

        Intent intent = new Intent(this, SignupActivity2.class);
        intent.putExtra("fullName", fullName);
        intent.putExtra("userName", userName);
        intent.putExtra("email", email);
        intent.putExtra("password", password);

        //Transition
        /*Pair pairs[] = new Pair[4];

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
        }*/
        Toast.makeText(this, "intent"+fullName, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "intent"+userName, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "intent"+email, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "intent"+password, Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }

    public void goLoginActivty(View view) {

        Intent intent = new Intent(this, LoginsActivity.class);
        startActivity(intent);
    }

    private boolean validateFullname(){

        String field = mFullName.getEditText().getText().toString().trim();

        if (field.isEmpty()){

            mFullName.setError("Ce champs ne peut etre vide");
            return false;
        }
        else {
            mFullName.setError(null);
            mFullName.setEnabled(false);
            return true;
        }

    }
    private boolean validateUsername(){

        String field = mUserName.getEditText().getText().toString().trim();
        String checkSpaces = "\\A\\w{1,20}\\z";

        if (field.isEmpty()){

            mUserName.setError("Ce champs ne peut etre vide");
            return false;
        }
        else if (field.length()>20){
            mUserName.setError("Pseudo trop long, max 10 caracteres");
            return false;
        }
        else if (!field.matches(checkSpaces)){
            mUserName.setError("les espaces ne sont pas autorises");
            return false;
        }
        else {
            mUserName.setError(null);
            mUserName.setEnabled(false);
            return true;
        }
    }
    private boolean validateEmail(){

        String field = mEmail.getEditText().getText().toString().trim();
        String checkEmail = "[a-z-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (field.isEmpty()){

            mEmail.setError("Ce champs ne peut etre vide");
            return false;
        }
        else if (!field.matches(checkEmail)){
            mEmail.setError("Ce format n'est pas valide");
            return false;
        }
        else {
            mEmail.setError(null);
            mEmail.setEnabled(false);
            return true;
        }

    }
    private boolean validatePassword(){

        String field = mPassword.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (field.isEmpty()){
            mPassword.setError("Ce champs ne peut etre vide");
            return false;
        }
        else if (!field.matches(checkPassword)){
            mPassword.setError("Minimum 4 caracteres");
            return false;
        }
        else {
            mPassword.setError(null);
            mPassword.setEnabled(false);
            return true;
        }
    }
}