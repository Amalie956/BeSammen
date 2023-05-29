package com.example.besammen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.besammen.R;

//Klara layout
public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        String username = getIntent().getStringExtra("userName");
        String age = getIntent().getStringExtra("age");
        showUser(username, age);
    }
    public void showUser(String username, String age) {
        TextView renderUsernameOnUserProfile = findViewById(R.id.anna_21);
        renderUsernameOnUserProfile.setText(username + ", " + age + " år");
    }
}