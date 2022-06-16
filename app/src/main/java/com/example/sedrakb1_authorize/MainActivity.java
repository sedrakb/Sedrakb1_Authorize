/*
Bichoy Sedrak - CSIT551 Summer 2022
M2: Individual Project - Register and Login

This is the Main Activity screen works as a login page.
 */


package com.example.sedrakb1_authorize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView Register;


    // linking the MainActivity class with the activity_main XML file.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText EnterEmail = findViewById(R.id.enteremail);
        final EditText EnterPassword = findViewById(R.id.password_toggle);

        Register = findViewById(R.id.register);
        Button Login = findViewById(R.id.login);

        Register.setOnClickListener(v -> openRegisterPage());

        // setting up the login button
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = EnterEmail.getText().toString();
                String password = EnterPassword.getText().toString();

                // shared preferences to show saved data on the register screen.
                SharedPreferences preferences = getSharedPreferences("Authorize", MODE_PRIVATE);

                String userDetails = preferences.getString("Authorize", String.valueOf(MODE_PRIVATE));
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display", userDetails);
                editor.apply();

                // intent to display the info
                Intent logininfo = new Intent(MainActivity.this, loginpage.class);
                startActivity(logininfo);
            }
        });

    }


    // method to open the register page when pressing the register button.

    public void openRegisterPage() {
        Intent register = new Intent(this, Register.class);
        startActivity(register);
    }
}

