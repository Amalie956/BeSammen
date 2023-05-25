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
import com.example.besammen.domain.User;
import com.example.besammen.domain.UserService;
import com.google.android.material.textfield.TextInputEditText;

public class UserRegistration extends AppCompatActivity {
    String[] items = {"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    String[] gender = {"Kvinde", "Mand", "Andet"};
    String[] diagnosis = {"ADHD"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItem;
    UserService userLoginService = new UserService(this);
    String userEmail;
    String userPassword;
    String username;
    String userAge;
    String userGender;
    String userDiagnosis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        setupDropdowns();

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

        registerButtonClick(buttonReg);
    }

    private void setupDropdowns() {
        ageDropdown();
        genderDropdown();
        diagnosisDropdown();
    }

    private void registerButtonClick(Button buttonReg) {
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User newUser = getUserFromInputFields();
                userLoginService.createUser(newUser);
            }
        });
    }

    private void diagnosisDropdown() {
        autoCompleteTextView = findViewById(R.id.diagnosis);
        adapterItem = new ArrayAdapter<String>(this, R.layout.dropdown_lists, diagnosis);
        autoCompleteTextView.setAdapter(adapterItem);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
        });
    }

    private void genderDropdown() {
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
    }

    private void ageDropdown() {
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
    }

    public User getUserFromInputFields() {
        TextInputEditText userName = findViewById(R.id.userName);
        AutoCompleteTextView age = findViewById(R.id.age);
        AutoCompleteTextView gender = findViewById(R.id.gender);
        AutoCompleteTextView diagnosis = findViewById(R.id.diagnosis);
        TextInputEditText editTextEmail = findViewById(R.id.email);
        TextInputEditText editTextPassword = findViewById(R.id.password);

        userEmail = String.valueOf(editTextEmail.getText());
        userPassword = String.valueOf(editTextPassword.getText());
        username = userName.getText().toString();
        userAge = age.getText().toString();
        userGender = gender.getText().toString();
        userDiagnosis = diagnosis.getText().toString();

        return new User(userEmail, userPassword, username, userGender, userAge, userDiagnosis);
    }
}


