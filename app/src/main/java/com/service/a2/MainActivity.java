package com.service.a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.util.PrefsHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    int SPLASH_TIME_OUT = 3000;

    void init() {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                String user_id = PrefsHelper.getString(MainActivity.this, "username");
                if (user_id != null && !user_id.isEmpty()) {
//                    Intent i = new Intent(MainActivity.this, DashboardActivity.class);
//                    startActivity(i);
//                    finish();
                } else {
                    Intent i = new Intent(MainActivity.this, SelectLanguageActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }
}