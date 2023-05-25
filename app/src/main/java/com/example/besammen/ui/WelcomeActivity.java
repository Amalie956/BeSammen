package com.example.besammen.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.besammen.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

public class WelcomeActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        imageView = findViewById(R.id.imageViewButton);
        button = findViewById(R.id.continuebtn);

        String username = getIntent().getStringExtra("userName");
        String age = getIntent().getStringExtra("age");
        showUser(username);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, OverviewActivity.class);
                intent.putExtra("userName", username);
                intent.putExtra("age", age);
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, OverviewActivity.class);
                intent.putExtra("userName", username);
                intent.putExtra("age", age);
                startActivity(intent);
            }
        });
    }

    public void showUser(String username) {
        TextView renderUsernameOnWelcomeActivity = findViewById(R.id.renderUsername);
        renderUsernameOnWelcomeActivity.setText("Velkommen " + username);
    }

}