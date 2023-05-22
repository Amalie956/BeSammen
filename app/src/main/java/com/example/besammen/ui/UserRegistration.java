package com.example.besammen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.example.besammen.R;
import com.example.besammen.domain.UserService;
import com.example.besammen.domain.UserValidator;
import com.google.android.material.textfield.TextInputEditText;

public class UserRegistration extends AppCompatActivity {
    String[] items ={"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    String[] gender ={"Kvinde", "Mand", "Andet"};
    String[] diagnosis ={"ADHD"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItem;

    UserService userLoginService = new UserService(this);
    UserValidator userLoginValidator = new UserValidator(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        //age dropdown
        autoCompleteTextView = findViewById(R.id.age);
        adapterItem = new ArrayAdapter<String>(this, R.layout.dropdown_lists, items);
        autoCompleteTextView.setAdapter(adapterItem);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
        });

        //gender dropdown
        autoCompleteTextView = findViewById(R.id.gender);
        adapterItem = new ArrayAdapter<String>(this, R.layout.dropdown_lists, gender);
        autoCompleteTextView.setAdapter(adapterItem);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
        });

        //diagnosis dropdown
        autoCompleteTextView = findViewById(R.id.diagnosis);
        adapterItem = new ArrayAdapter<String>(this, R.layout.dropdown_lists, diagnosis);
        autoCompleteTextView.setAdapter(adapterItem);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
        });

        TextInputEditText editTextEmail = findViewById(R.id.email);
        TextInputEditText editTextPassword = findViewById(R.id.password);
        Button buttonReg = findViewById(R.id.btn_register);
        TextView textView = findViewById(R.id.loginNow);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserRegistration.this, UserLogin.class);
                startActivity(intent);
                finish();
            }
        });

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());

                boolean x = userLoginValidator.createUserValidator(email, password);

                if (x == true) {
                    userLoginService.createUserMethod(email, password);
                }
            }
        });
    }
}