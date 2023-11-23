package com.essycynthia.todojava.presentation.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.essycynthia.countries.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        login();
        register();
    }

    private void register() {
        EditText et_email = findViewById(R.id.registerEmail);
        EditText et_password = findViewById(R.id.registerPassword);
        EditText et_username = findViewById(R.id.registerUsername);
        EditText et_confirmPassword = findViewById(R.id.registerConfirmPassword);
        Button bt_createAccountButton = findViewById(R.id.registerButton);

        bt_createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();
                String username = et_username.getText().toString();
                String confirmPassword = et_confirmPassword.getText().toString();
                if (email != null && password != null){
                    Intent registerIntent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(registerIntent);
                } else if (email.isEmpty()) {
                    Toast.makeText(RegisterActivity.this,
                                    "Please enter an email address",
                                    Toast.LENGTH_SHORT)
                            .show();

                }else {
                    Toast.makeText(RegisterActivity.this,
                                    "Please enter a password",
                                    Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

    private void login() {
        TextView login = findViewById(R.id.loginText);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}