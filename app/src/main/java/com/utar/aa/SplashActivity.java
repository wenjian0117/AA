package com.utar.aa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int SPLASH_DISPLAY_LENGTH = 1000; // 1000 milliseconds = 1 second

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                // Create an Intent that will start the main activity.
                Intent Intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(Intent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}