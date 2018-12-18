package com.example.bugfreeram.samyak.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.bugfreeram.samyak.Custom.DbHelper;
import com.example.bugfreeram.samyak.Custom.InputValidation;
import com.example.bugfreeram.samyak.MainActivity;
import com.example.bugfreeram.samyak.Models.User;
import com.example.bugfreeram.samyak.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Signup extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = Signup.this;


    boolean isFlagReset = false;
    Context mContext;
    String username, name, email, mobile, password;
    private NestedScrollView nestedScrollView;
    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutConfirmPassword;
    private TextInputLayout textInputLayoutMobile;
    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextConfirmPassword;
    private TextInputEditText textInputEditTextMob;
    private AppCompatButton appCompatButtonRegister;
    private AppCompatTextView appCompatTextViewLoginLink;
    private InputValidation inputValidation;
    private User user;
    private DbHelper db;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mContext = this;
        initViews();
        initListeners();
        initObjects();
    }
    private void initViews() {
        radioSexGroup = (RadioGroup) findViewById(R.id.radio);
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        textInputLayoutName = (TextInputLayout) findViewById(R.id.textInputLayoutName);
        textInputLayoutMobile = (TextInputLayout) findViewById(R.id.textInputLayoutMobile);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmailReg);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutConfirmPassword = (TextInputLayout) findViewById(R.id.textInputLayoutConfirmPassword);
        textInputEditTextName = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmailReg);
        textInputEditTextMob = (TextInputEditText) findViewById(R.id.textInputEditTextMobile);

        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        textInputEditTextConfirmPassword = (TextInputEditText) findViewById(R.id.textInputEditTextConfirmPassword);
        appCompatButtonRegister = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);
        appCompatTextViewLoginLink = (AppCompatTextView) findViewById(R.id.appCompatTextViewLoginLink);

        db = new DbHelper(this);
    }

    private void initListeners() {
        appCompatButtonRegister.setOnClickListener(this);
        appCompatTextViewLoginLink.setOnClickListener(this);
    }

    private void initObjects() {
        inputValidation = new InputValidation(activity);
        user = new User();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonRegister:


                textInputLayoutName.setError(null);
                textInputLayoutEmail.setError(null);
                textInputLayoutPassword.setError(null);
                textInputLayoutConfirmPassword.setError(null);
                textInputLayoutMobile.setError(null);

                if (textInputEditTextName.getText().toString().trim().length() <= 3) {
                    textInputLayoutName.setError("Name is Required Properly");
                } else if (!isValidEmail(textInputEditTextEmail.getText().toString().trim())) {
                    textInputLayoutEmail.setError("Email is required");
                } else if (textInputEditTextMob.getText().toString().trim().length() <= 5) {
                    textInputLayoutMobile.setError("Enter a valid Mobile Number");

                } else if (!isValidPass(textInputEditTextPassword.getText().toString().trim())) {
                    textInputLayoutPassword.setError("Password is Require");

                } else if (!isValidPass(textInputEditTextConfirmPassword.getText().toString().trim())) {
                    textInputLayoutConfirmPassword.setError("password is require");
                } else {

                    if (!isFlagReset) {
                        register();
                        /*sendRegData();*/

                    }
                }
                break;
            case R.id.appCompatTextViewLoginLink:
                Intent loginIntent = new Intent(Signup.this, MainActivity.class);
                startActivity(loginIntent);
                finish();
                break;
        }
    }

    private boolean isValidEmail(String email) {

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPass(String pass) {
        if (pass != null && pass.length() > 5) {
            return true;
        }
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(pass);

        return matcher.matches();
    }

    private void sendRegData() {
        username = textInputEditTextName.getText().toString();
        name = textInputEditTextName.getText().toString();
        email = textInputEditTextEmail.getText().toString();
        password = textInputEditTextPassword.getText().toString();

        mobile = textInputEditTextMob.getText().toString();
        Intent intent = new Intent(Signup.this, LoginActivity.class);
        startActivity(intent);

    }

    private void register() {
        email = textInputEditTextEmail.getText().toString();
        password = textInputEditTextPassword.getText().toString();
        if (email.isEmpty() && password.isEmpty()) {
            displayToast("Username/password field empty");
        } else {
            db.addUser(email, password);

            sendRegData();

        }
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}