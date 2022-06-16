package com.example.sedrakb1_authorize;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    protected void onCreate (Bundle savedInstanceState) {
    // linking the splash screen xml to the java class
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // hiding the action bar on the splash screen
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },4000);     // will display for 4 seconds
    }
}
