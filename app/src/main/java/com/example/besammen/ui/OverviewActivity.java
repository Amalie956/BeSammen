package com.example.besammen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.besammen.R;
import com.example.besammen.domain.User;

public class OverviewActivity extends AppCompatActivity {

ImageButton imageButtonProfile;

ImageButton imageButtonGroupchat;

ImageButton imageButtonEvents;

ImageButton imageButtonSettings;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview_app_activities);

        imageButtonProfile = (ImageButton) findViewById(R.id.imageButton7);

        imageButtonGroupchat = (ImageButton) findViewById(R.id.imageButton8);

        imageButtonEvents = (ImageButton) findViewById(R.id.imageButton10);

        imageButtonSettings = (ImageButton) findViewById(R.id.imageButton14);

        imageButtonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OverviewActivity.this, UserProfile.class);
                startActivity(intent);
            }
        });


        imageButtonGroupchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OverviewActivity.this, GroupChatOverview.class);
                startActivity(intent);
            }
        });

        imageButtonEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OverviewActivity.this, UserEvents.class);
                startActivity(intent);
            }
        });
        imageButtonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OverviewActivity.this, UserSettings.class);
                startActivity(intent);
            }
        });

    }
}
