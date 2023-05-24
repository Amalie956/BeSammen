package com.example.besammen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.besammen.R;
import com.example.besammen.domain.UserService;
import com.example.besammen.domain.UserValidator;
import com.google.android.material.textfield.TextInputEditText;

public class UserLogin extends AppCompatActivity {
    UserService userLoginService = new UserService(this);
    UserValidator userLoginValidator = new UserValidator(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        TextInputEditText editTextEmail = findViewById(R.id.email);
        TextInputEditText editTextPassword = findViewById(R.id.password);
        Button buttonLogin = findViewById(R.id.btn_login);
        Button buttonCreateUser = findViewById(R.id.create_user);

        setCreateUserClickListener(buttonCreateUser);
        setLoginClickListener(editTextEmail, editTextPassword, buttonLogin);
    }

    private void setLoginClickListener(TextInputEditText editTextEmail, TextInputEditText editTextPassword, Button buttonLogin) {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());

                boolean isUserInputValid = userLoginValidator.loginValidator(email, password);

                if (isUserInputValid == true) {
                    userLoginService.loginMethod(email, password);
                }
            }
        });
    }

    private void setCreateUserClickListener(Button buttonCreateUser) {
        buttonCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserLogin.this, UserRegistration.class);
                startActivity(intent);
                finish();
            }
        });
    }
}