package com.essycynthia.todojava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.essycynthia.countries.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();
        register();
    }

    private void register() {
        TextView register = findViewById(R.id.signUpText);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUp = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(signUp);
            }
        });
    }

    private void login() {
        EditText et_mail = findViewById(R.id.loginUsername);
        EditText et_password = findViewById(R.id.loginPassword);
        Button bt_loginButton = findViewById(R.id.loginButton);

        bt_loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_mail.getText().toString();
                String password = et_password.getText().toString();
                if (email != null && password != null){
                    Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(loginIntent);
                } else if (email.isEmpty()) {
                    Toast.makeText(LoginActivity.this,
                                    "Please enter an email address",
                                    Toast.LENGTH_SHORT)
                            .show();

                }else {
                    Toast.makeText(LoginActivity.this,
                                    "Please enter a password",
                                    Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

    }

}