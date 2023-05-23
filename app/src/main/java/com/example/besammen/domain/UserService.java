package com.example.besammen.domain;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.besammen.ui.OverviewActivity;
import com.example.besammen.ui.UserLogin;
import com.example.besammen.ui.UserRegistration;
import com.example.besammen.ui.WelcomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserService {
    private Context context;
    private FirebaseAuth firebaseAuth;

    public UserService(Context context) {
        this.context = context;
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void loginMethod(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context, OverviewActivity.class);
                            context.startActivity(intent);
                            // Finish the current activity if needed
                            // ((Activity) context).finish();
                        } else {
                            Toast.makeText(context, "Login Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void createUserMethod(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(context, "Register Successful", Toast.LENGTH_SHORT).show();
                            //Intent intent = new Intent(context, WelcomeActivity.class);
                            //context.startActivity(intent);
                            // Finish the current activity if needed
                            // ((Activity) context).finish();
                        } else {
                            Toast.makeText(context, "Register Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
