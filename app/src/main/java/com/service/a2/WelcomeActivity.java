package com.service.a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.util.LocaleHelper;

public class WelcomeActivity extends AppCompatActivity {

    Context context;
    ImageView back_imageview;
    Button already_a_customer_btn, new_to_app_btn, skip_sign_in_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();
    }

    void init() {
        context = this;
        back_imageview = findViewById(R.id.back_imageview);
        already_a_customer_btn = findViewById(R.id.already_a_customer_btn);
        skip_sign_in_btn = findViewById(R.id.skip_sign_in_btn);
        new_to_app_btn = findViewById(R.id.new_to_app_btn);
        back_imageview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        WelcomeActivity.super.onBackPressed();
                    }
                }
        );
        already_a_customer_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(WelcomeActivity.this, RegistrationActivity.class);
                        intent.putExtra("type", "signin");
                        startActivity(intent);
                    }
                }
        );
        new_to_app_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(WelcomeActivity.this, RegistrationActivity.class);
                        intent.putExtra("type", "reg");
                        startActivity(intent);
                    }
                }
        );
        skip_sign_in_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(WelcomeActivity.this, DashboardActivity.class);
//                        intent.putExtra("type", "reg");
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

/*
https://play.google.com/store/apps/details?id=com.newudlifemobile
https://play.google.com/console/u/0/developers/5866583081184525373/app/4976038553438725690/app-dashboard?timespan=thirtyDays&showKpiMenu=null
https://play.google.com/store/apps/details?id=com.service.firepocket
https://play.google.com/store/apps/details?id=com.service.manyafashion
https://play.google.com/store/apps/details?id=com.service.propsurgen
https://play.google.com/store/apps/details?id=com.rav.raverp
 */
