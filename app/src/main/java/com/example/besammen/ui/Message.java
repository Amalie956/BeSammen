package com.example.besammen.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.besammen.R;
import com.example.besammen.domain.MessageService;

import java.util.ArrayList;

public class Message extends AppCompatActivity {
    private ListView listViewForMessages;
    private Button sendMessageButton;
    private EditText editTextForMessage;
    private String username;

    MessageService chatService = new MessageService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        username = getIntent().getStringExtra("userName");

        sendMessageButton = findViewById(R.id.sendMessageButton);
        listViewForMessages = findViewById(R.id.listViewForMessages);
        editTextForMessage = findViewById(R.id.editTextForMessage);

        ArrayList<String> arrayListForMessages = new ArrayList<>();

        chatService.updateDatabase(listViewForMessages, arrayListForMessages);

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editTextForMessage.getText().toString();
                chatService.addMessage(username, message);
            }
        });
    }

}
