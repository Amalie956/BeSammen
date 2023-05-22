package com.example.besammen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.besammen.R;

public class GroupChatOverview extends AppCompatActivity {

    ImageView imageViewGroupChatForAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat_overview);

        imageViewGroupChatForAll = findViewById(R.id.imageView25);

        imageViewGroupChatForAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GroupChatOverview.this, Message.class);
                startActivity(intent);
            }
        });

    }
}
