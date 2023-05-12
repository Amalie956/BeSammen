package com.example.besammen.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.besammen.R;
import com.example.besammen.UserLogin;
import com.example.besammen.UserRegistration;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, UserLogin.class);
        startActivity(intent);
        finish();
    }
}
