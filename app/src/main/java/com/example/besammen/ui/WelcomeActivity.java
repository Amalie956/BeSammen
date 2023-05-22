package com.example.besammen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.besammen.R;

public class WelcomeActivity extends AppCompatActivity {
    //ImageView imageView;

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //imageView = findViewById(R.id.imageView);

        button = findViewById(R.id.continuebtn);


        button.setOnClickListener(new View.OnClickListener() {
        //imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //Når man trykker på billedet, kommer man hen til Overview siden
                Intent intent = new Intent(WelcomeActivity.this, Message.class);
                startActivity(intent);
            }
        });
    }
}