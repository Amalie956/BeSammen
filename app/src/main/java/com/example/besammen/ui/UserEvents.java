package com.example.besammen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.besammen.R;

public class UserEvents extends AppCompatActivity {
    ImageButton imageButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_events);

        imageButton = findViewById(R.id.meet_people);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //Når man trykker på billedet, kommer man hen til Overview siden
                Intent intent = new Intent(UserEvents.this, Event_meet_people.class);
                startActivity(intent);
            }
        });
    }
}