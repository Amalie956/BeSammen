package com.example.besammen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.besammen.R;

public class GroupChatOverview extends AppCompatActivity {

    ImageView imageViewGroupChatForAll;

    ImageView imageViewWomen1821;

    ImageView imageViewAllWomen;

    ImageView imageViewYoungMothers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat_overview);

        imageViewGroupChatForAll = findViewById(R.id.imageView25);

        imageViewWomen1821 = findViewById(R.id.imageView10);

        imageViewAllWomen = findViewById(R.id.imageView24);

        imageViewYoungMothers = findViewById(R.id.imageView23);

        imageViewGroupChatForAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GroupChatOverview.this, Message.class);
                startActivity(intent);
            }
        });

        imageViewWomen1821.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GroupChatOverview.this, "This group chat is under development", Toast.LENGTH_SHORT).show();
            }
        });
        imageViewAllWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GroupChatOverview.this, "This group chat is under development", Toast.LENGTH_SHORT).show();
            }
        });
        imageViewYoungMothers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GroupChatOverview.this, "This group chat is under development", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
