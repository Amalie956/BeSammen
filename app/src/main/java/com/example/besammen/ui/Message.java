package com.example.besammen.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.besammen.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Message extends AppCompatActivity {
    ListView listViewForMessages;
    Button sendMessageButton;
    EditText editTextForMessage;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        username = getIntent().getStringExtra("userName");

        sendMessageButton = findViewById(R.id.sendMessageButton);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        ArrayList arrayListForMessages = new ArrayList();
        listViewForMessages = findViewById(R.id.listViewForMessages);
        editTextForMessage = findViewById(R.id.editTextForMessage);
        db.getReference("Messages").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.d("Message", "Child added: " + snapshot.getValue().toString());
                //Toast.makeText(Message.this, "Message added: " + snapshot.getValue().toString(), Toast.LENGTH_SHORT).show();
                arrayListForMessages.add(snapshot.getValue().toString());
                ArrayAdapter adapter = new ArrayAdapter(Message.this, android.R.layout.simple_list_item_1, arrayListForMessages);
                listViewForMessages.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                Date getDate = Calendar.getInstance().getTime();
                db.getReference("Messages").child(auth.getUid() + getDate).setValue(username + "\n" + editTextForMessage.getText().toString());
                Toast.makeText(Message.this, "Sent", Toast.LENGTH_SHORT).show();
            }
        });
    }
}