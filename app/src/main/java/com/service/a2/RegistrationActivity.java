package com.service.a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.util.LocaleHelper;

public class RegistrationActivity extends AppCompatActivity {

    LinearLayout registration_linear, signin_linear;
    RadioButton create_an_account_radio_btn, signin_radio_btn;
    TextView forget_password_tv;
    Button signin_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        init();
    }

    void init() {
        signin_linear = findViewById(R.id.signin_linear);
        registration_linear = findViewById(R.id.registration_linear);
        create_an_account_radio_btn = findViewById(R.id.create_an_account_radio_btn);
        signin_radio_btn = findViewById(R.id.signin_radio_btn);
        forget_password_tv = findViewById(R.id.forget_password_tv);
        signin_btn = findViewById(R.id.signin_btn);

        Intent intent = getIntent();
        create_an_account_radio_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        signin_radio_btn.setChecked(false);
                        registration_linear.setVisibility(View.VISIBLE);
                        signin_linear.setVisibility(View.GONE);
                    }
                }
        );
        signin_radio_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        registration_linear.setVisibility(View.GONE);
                        signin_linear.setVisibility(View.VISIBLE);
                        create_an_account_radio_btn.setChecked(false);
                    }
                }
        );
        String type = intent.getStringExtra("type");

        if (type.equals("signin")) {
            registration_linear.setVisibility(View.GONE);
            signin_linear.setVisibility(View.VISIBLE);
            create_an_account_radio_btn.setChecked(false);
            signin_radio_btn.setChecked(true);

        } else if (type.equals("reg")) {
            signin_radio_btn.setChecked(false);
            registration_linear.setVisibility(View.VISIBLE);
            signin_linear.setVisibility(View.GONE);
            create_an_account_radio_btn.setChecked(true);
        }
        forget_password_tv.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(RegistrationActivity.this, ForgetPasswordActivity.class);
                        startActivity(intent);
                    }
                }
        );
        signin_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(RegistrationActivity.this,DashboardActivity.class);
                        startActivity(intent);
                    }
                }
        );


    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }
}