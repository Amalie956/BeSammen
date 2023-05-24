package com.example.besammen.ui;

import androidx.annotation.NonNull;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UserRegistration extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    String[] items = {"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    String[] gender = {"Kvinde", "Mand", "Andet"};
    String[] diagnosis = {"ADHD"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItem;

    UserService userLoginService = new UserService(this);
    UserValidator userLoginValidator = new UserValidator(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        setupDropdowns();


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

        registerButtonClick(editTextEmail, editTextPassword, buttonReg);

    }

    private void setupDropdowns() {
        ageDropdown();
        genderDropdown();
        diagnosisDropdown();
    }

    private void registerButtonClick(TextInputEditText editTextEmail, TextInputEditText editTextPassword, Button buttonReg) {
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
                setUserData();
            }
        });
    }

    private void diagnosisDropdown() {
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


    public void setUserData() {
        TextInputEditText userName = findViewById(R.id.userName);
        AutoCompleteTextView age = findViewById(R.id.age);
        AutoCompleteTextView gender = findViewById(R.id.gender);
        AutoCompleteTextView diagnosis = findViewById(R.id.diagnosis);

        String getUsername = userName.getText().toString();
        String getAge = age.getText().toString();
        String getGender = gender.getText().toString();
        String getDiagnosis = diagnosis.getText().toString();

        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("userName", getUsername);
        hashMap.put("age", getAge);
        hashMap.put("gender", getGender);
        hashMap.put("userDiagnosis", getDiagnosis);

        db.collection("Users")
                .add(hashMap)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        System.out.println("added");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("error");
                        System.out.println(e);
                    }
                });
        getUsername(getUsername, getAge);
    }

    public void getUsername(String username, String age) {
        Intent intent = new Intent(UserRegistration.this, WelcomeActivity.class);
        intent.putExtra("userName", username);
        intent.putExtra("age", age);
        startActivity(intent);
    }


}


