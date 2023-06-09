package com.example.besammen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.besammen.R;

//Abdul
//Klara layout
public class UserSettings extends AppCompatActivity {

    private ImageView imageForProfileSettings;
    private ImageView imageViewLanguage;
    private ImageView imageViewDarkMode;
    private ImageView imageForProfileArrow;
    private Button logOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);

        imageForProfileSettings = findViewById(R.id.imageView15);

        imageForProfileArrow = findViewById(R.id.imageView3);

        imageViewLanguage = findViewById(R.id.imageView16);

        imageViewDarkMode = findViewById(R.id.imageView14);

        logOutButton = findViewById(R.id.button4);

        imageForProfileSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserSettings.this, "Denne indstilling er under udvikling", Toast.LENGTH_SHORT).show();
            }
        });

        imageForProfileArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserSettings.this, "Denne indstilling er under udvikling", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserSettings.this, "Denne indstilling er under udvikling", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewDarkMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserSettings.this, "Denne indstilling er under udvikling", Toast.LENGTH_SHORT).show();
            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserSettings.this, UserLogin.class);
                startActivity(intent);
            }
        });
    }
}