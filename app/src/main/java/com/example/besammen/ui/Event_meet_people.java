package com.example.besammen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.besammen.R;

public class Event_meet_people extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_meet_people);
    }

    public void participateButton (View view){
        Toast.makeText(this, "Du er nu tilmeldt", Toast.LENGTH_SHORT).show();
    }



}