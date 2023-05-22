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

    Button button;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        imageView = findViewById(R.id.imageViewButton);


        button = findViewById(R.id.continuebtn);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, OverviewActivity.class);
                startActivity(intent);
            }
        });


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