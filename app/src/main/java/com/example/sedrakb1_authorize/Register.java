package com.example.sedrakb1_authorize;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity implements View.OnClickListener {

// linking all the views with the java class using the R method.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText fName = findViewById(R.id.first_name);
        final EditText lName = findViewById(R.id.last_name);
        final EditText Dob = findViewById(R.id.dob);
        final EditText Email = findViewById(R.id.email);
        final EditText Password = findViewById(R.id.password);

        final Button buttonRegister = findViewById(R.id.bRegister);
        final TextView alreadyUser = findViewById(R.id.alreadyuser);

// setting up the already user link to retun to login page
        alreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { returntoLoginPage();

            }
        });
// setting up the register button
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    // using the shared preferences to save the entred data by the user.
                SharedPreferences preferences = getSharedPreferences("Authorize", MODE_PRIVATE);
                String firstName = fName.getText().toString();
                String lastName = lName.getText().toString();
                String dateOfBirth = Dob.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(" First Name", firstName);
                editor.putString("Last Name", lastName);
                editor.putString("Date of Birth", dateOfBirth);
                editor.putString("Email", email);
                editor.putString("Password", password);
                editor.apply();

// using if method to validate that entered data is not empty.
                if (TextUtils.isEmpty(Email.getText().toString().trim()) || (TextUtils.isEmpty(fName.getText().toString().trim())) || (TextUtils.isEmpty(Dob.getText().toString().trim())) || (TextUtils.isEmpty(Password.getText().toString().trim()))) {
                    Toast.makeText(Register.this, "Please Fill in all fields! ", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Register.this, "You have registered successfully! ", Toast.LENGTH_LONG).show();
// intent to return to the login screen
                    Intent loginScreen = new Intent(Register.this, MainActivity.class);
                    startActivity(loginScreen);
                }
            }
        });
// the return to login page method used in the link for already a user on line 31
    }
    private void returntoLoginPage() {
        Intent login = new Intent(this, MainActivity.class);
        startActivity(login);
    }

    @Override
    public void onClick(View v) {

    }
}
