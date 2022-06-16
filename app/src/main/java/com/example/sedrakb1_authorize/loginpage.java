package com.example.sedrakb1_authorize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class loginpage extends AppCompatActivity {

    Button logout;
    // linking all the views with the java class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
// set up a shared prefrences to display the registered info.
        SharedPreferences preferences = getSharedPreferences("Authorize", MODE_PRIVATE);
        String display = preferences.getString("display", "");

        TextView displayinfo = findViewById(R.id.firstname);
        displayinfo.setText(display);

// set up the logout button to return to the main screen
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returntomain = new Intent(loginpage.this, MainActivity.class);
                startActivity(returntomain);
            }
        });
    }
}