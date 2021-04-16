package com.service.a2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.util.LocaleHelper;
import com.util.PrefsHelper;

public class SelectLanguageActivity extends AppCompatActivity {

    Context context;
    CardView english_cardview, hindi_cardview, punjabi_cardview, odiya_cardview, kannada_cardview, telugu_cardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_select_language);

        init();
    }

    void init() {
        context = this;
        english_cardview = findViewById(R.id.english_cardview);
        hindi_cardview = findViewById(R.id.hindi_cardview);
        punjabi_cardview = findViewById(R.id.punjabi_cardview);
        odiya_cardview = findViewById(R.id.odiya_cardview);
        kannada_cardview = findViewById(R.id.kannada_cardview);
        telugu_cardview = findViewById(R.id.telugu_cardview);

        english_cardview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setLanguage("en", "english");
                        Intent intent = new Intent(context, WelcomeActivity.class);
                        startActivity(intent);
                    }
                }
        );
        hindi_cardview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setLanguage("hi", "hindi");
                        Intent intent = new Intent(context, WelcomeActivity.class);
                        startActivity(intent);
                    }
                }
        );
        punjabi_cardview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, WelcomeActivity.class);
                        startActivity(intent);
                    }
                }
        );
        odiya_cardview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, WelcomeActivity.class);
                        startActivity(intent);
                    }
                }
        );
        kannada_cardview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, WelcomeActivity.class);
                        startActivity(intent);
                    }
                }
        );
        telugu_cardview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, WelcomeActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void setLanguage(String lang_code, String lang_name) {
        PrefsHelper.putString(this, "lang_code", lang_code);
        PrefsHelper.putString(this, "lang_name", lang_name);

        LocaleHelper.setLocale(SelectLanguageActivity.this, lang_code);

        Intent intent = new Intent(SelectLanguageActivity.this, SelectLanguageActivity.class);
        startActivity(intent);
        finish();
    }
}