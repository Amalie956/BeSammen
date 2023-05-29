package com.example.besammen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.besammen.R;

//Abdul
//Klara layout
public class Event_meet_people extends AppCompatActivity {

    private Button participateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_meet_people);

        participateButton = findViewById(R.id.participate_button);
    }

    public void participateButton (View view){
        Toast.makeText(this, "Du er nu tilmeldt", Toast.LENGTH_SHORT).show();
    }

}