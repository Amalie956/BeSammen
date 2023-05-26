package com.example.besammen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.besammen.R;

//Abdul
public class UserEvents extends AppCompatActivity {
    ImageButton imageButtonMeetPeople;
    ImageButton imageButtonBrunch;
    ImageView imageViewMindfulness;
    ImageButton imageButtonGroupTherapy;
    ImageButton imageButtonShoppingMate;
    ImageButton imageButtonKlatre;
    ImageButton imageButtonCreative;
    ImageButton imageButtonWebinar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_events);

        imageButtonMeetPeople = findViewById(R.id.meet_people);

        imageButtonBrunch = findViewById(R.id.imageViewButton7);

        imageViewMindfulness = findViewById(R.id.imageView11);

        imageButtonGroupTherapy = findViewById(R.id.imageButton10);

        imageButtonShoppingMate = findViewById(R.id.imageButton11);

        imageButtonKlatre = findViewById(R.id.imageButton12);

        imageButtonCreative = findViewById(R.id.imageButton13);

        imageButtonWebinar = findViewById(R.id.imageButton14);

        imageButtonMeetPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //Når man trykker på billedet, kommer man hen til Overview siden
                Intent intent = new Intent(UserEvents.this, Event_meet_people.class);
                startActivity(intent);
            }
        });

        imageButtonBrunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserEvents.this, "This event is under development", Toast.LENGTH_SHORT).show();
            }
        });
        imageViewMindfulness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserEvents.this, "This event is under development", Toast.LENGTH_SHORT).show();
            }
        });

        imageButtonGroupTherapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserEvents.this, "This event is under development", Toast.LENGTH_SHORT).show();
            }
        });

        imageButtonShoppingMate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserEvents.this, "This event is under development", Toast.LENGTH_SHORT).show();
            }
        });
        imageButtonKlatre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserEvents.this, "This event is under development", Toast.LENGTH_SHORT).show();
            }
        });
        imageButtonCreative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserEvents.this, "This event is under development", Toast.LENGTH_SHORT).show();
            }
        });

        imageButtonWebinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserEvents.this, "This event is under development", Toast.LENGTH_SHORT).show();
            }
        });

    }

}