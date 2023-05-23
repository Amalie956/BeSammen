package com.example.besammen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.besammen.R;
import com.example.besammen.domain.User;

public class OverviewActivity extends AppCompatActivity {

ImageButton imageButtonProfile;
ImageButton imageButtonGroupchat;
ImageButton imageButtonEvents;
ImageButton imageButtonSettings;
ImageButton imageButtonPrivateChat;
ImageButton imageButtonFriends;
ImageButton imageButtonKnowledge;
ImageButton imageButtonAsk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview_app_activities);

        imageButtonProfile = (ImageButton) findViewById(R.id.imageButton7);

        imageButtonGroupchat = (ImageButton) findViewById(R.id.imageButton8);

        imageButtonEvents = (ImageButton) findViewById(R.id.imageButton10);

        imageButtonSettings = (ImageButton) findViewById(R.id.imageButton14);

        imageButtonPrivateChat = (ImageButton) findViewById(R.id.imageButton9);

        imageButtonFriends = (ImageButton) findViewById(R.id.imageButton11);

        imageButtonKnowledge = (ImageButton) findViewById(R.id.imageButton12);

        imageButtonAsk = (ImageButton) findViewById(R.id.imageButton13);

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

        imageButtonPrivateChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OverviewActivity.this, "This function is under development", Toast.LENGTH_SHORT).show();
            }
        });
        imageButtonFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OverviewActivity.this, "This function is under development", Toast.LENGTH_SHORT).show();
            }
        });
        imageButtonKnowledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OverviewActivity.this, "This function is under development", Toast.LENGTH_SHORT).show();
            }
        });
        imageButtonAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OverviewActivity.this, "This function is under development", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
