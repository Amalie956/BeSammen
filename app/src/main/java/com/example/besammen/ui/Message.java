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
import android.widget.Toast;

import com.example.besammen.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Message extends AppCompatActivity {

    ListView lv;
    Button send;

    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        send=findViewById(R.id.send);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        ArrayList al = new ArrayList();
        lv=findViewById(R.id.lv);
        ed=findViewById(R.id.edmsg);
        db.getReference("Messages").addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.d("Message", "Child added: " + snapshot.getValue().toString());
                //Toast.makeText(Message.this, "Message added: " + snapshot.getValue().toString(), Toast.LENGTH_SHORT).show();
                al.add(snapshot.getValue().toString());
                ArrayAdapter adapter = new ArrayAdapter(Message.this, android.R.layout.simple_list_item_1, al);
                lv.setAdapter(adapter);
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

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                Date getDate = Calendar.getInstance().getTime();
                db.getReference("Messages").child(auth.getUid()+getDate).setValue(ed.getText().toString());
            }
        });



    }


}