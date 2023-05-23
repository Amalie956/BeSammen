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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.besammen.R;
import com.example.besammen.domain.UserService;
import com.example.besammen.domain.UserValidator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class UserRegistration extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String uid = user.getUid();


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
                setUserData();
            }
        });


    }


    public void setUserData() {


        //TextInputEditText email = findViewById(R.id.email);
        TextInputEditText userName = findViewById(R.id.userName);
        AutoCompleteTextView age = findViewById(R.id.age);
        AutoCompleteTextView gender = findViewById(R.id.gender);
        AutoCompleteTextView diagnosis = findViewById(R.id.diagnosis);

        //String getEmail = email.getText().toString();
        String getUsername = userName.getText().toString();
        String getAge = age.getText().toString();
        String getGender = gender.getText().toString();
        String getDiagnosis = diagnosis.getText().toString();

        Map<String, Object> hashMap = new HashMap<>();
        //hashMap.put("email", getEmail);
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

    }



/*
    public void setUserData(View view) {
        AutoCompleteTextView userNameView = findViewById(R.id.userName);
        String userName = userNameView.getText().toString();
        AutoCompleteTextView ageView = findViewById(R.id.age);
        String age = ageView.getText().toString();
        AutoCompleteTextView genderView = findViewById(R.id.gender);
        String gender = genderView.getText().toString();
        AutoCompleteTextView diagnosisView = findViewById(R.id.diagnosis);
        String diagnosis = diagnosisView.getText().toString();

        // Create a Map object with user data
        Map<String, Object> user = new HashMap<>();
        user.put("userName", userName);
        user.put("age", age);
        user.put("gender", gender);
        user.put("diagnosis", diagnosis);

        // Save the data to the database
        db.collection("Users")
                .document(uid)
                .set(user)
                .addOnSuccessListener(aVoid -> System.out.println("Data added"))
                .addOnFailureListener(e -> {
                    System.out.println("Error adding data: " + e);
                    e.printStackTrace();
                });
    }

    public void getUserData(View view) {
        db.collection("Users")
                .document(uid)
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        System.out.println(documentSnapshot.getData());
                    } else {
                        System.out.println("Document does not exist");
                    }
                })
                .addOnFailureListener(e -> {
                    System.out.println("Error getting document: " + e);
                    e.printStackTrace();
                });
    }
 */

}


