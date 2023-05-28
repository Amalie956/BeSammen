package com.example.besammen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.besammen.R;

//Abdul
public class GroupChatOverview extends AppCompatActivity {
    private ImageView imageViewGroupChatForAll;
    private ImageView imageViewWomen1821;
    private ImageView imageViewAllWomen;
    private ImageView imageViewYoungMothers;
    private ImageView admin1;
    private ImageView admin2;
    private ImageView moderator1;
    private ImageView moderator2;
    private ImageView admin3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat_overview);

        String username = getIntent().getStringExtra("userName");

        imageViewGroupChatForAll = findViewById(R.id.imageView25);

        imageViewWomen1821 = findViewById(R.id.imageView10);

        imageViewAllWomen = findViewById(R.id.imageView24);

        imageViewYoungMothers = findViewById(R.id.imageView23);

        admin1 = findViewById(R.id.imageView3);

        admin2 = findViewById(R.id.imageView4);

        moderator1 = findViewById(R.id.imageView7);

        moderator2 = findViewById(R.id.imageView5);

        admin3 = findViewById(R.id.imageView8);

        imageViewGroupChatForAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GroupChatOverview.this, Message.class);
                intent.putExtra("userName", username);
                startActivity(intent);
            }
        });

        imageViewWomen1821.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GroupChatOverview.this, "Denne gruppechat er under udvikling", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewAllWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GroupChatOverview.this, "Denne gruppechat er under udvikling", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewYoungMothers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GroupChatOverview.this, "Denne gruppechat er under udvikling", Toast.LENGTH_SHORT).show();
            }
        });

        admin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GroupChatOverview.this, "Admin er i gang med at blive tildelt", Toast.LENGTH_SHORT).show();
            }
        });

        admin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GroupChatOverview.this, "Admin er i gang med at blive tildelt", Toast.LENGTH_SHORT).show();
            }
        });

        moderator1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GroupChatOverview.this, "Moderatoren er i gang med at blive tildelt", Toast.LENGTH_SHORT).show();
            }
        });

        moderator2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GroupChatOverview.this, "Moderatoren er i gang med at blive tildelt", Toast.LENGTH_SHORT).show();
            }
        });

        admin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GroupChatOverview.this, "Admin er i gang med at blive tildelt", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
