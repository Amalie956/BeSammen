package com.example.besammen.repository;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MessageRepository {
   private FirebaseDatabase db = FirebaseDatabase.getInstance();
    public void addMessageToChat(ListView listViewForMessages, ArrayList<String> arrayListForMessages, Context context) {
        db.getReference("Messages").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.d("Message", "Child added: " + snapshot.getValue().toString());
                arrayListForMessages.add(snapshot.getValue().toString());
                ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, arrayListForMessages);
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
    }

    public void addMessage(String username, String message) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        Date getDate = Calendar.getInstance().getTime();
        db.getReference("Messages").child(auth.getUid() + getDate).setValue(username + "\n" + message);
    }
}
