package com.example.besammen.domain;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.example.besammen.repository.UserRepository;
import com.example.besammen.ui.OverviewActivity;
import com.example.besammen.ui.WelcomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserService {
    private UserValidatorService userLoginValidator;
    private Context context;
    private FirebaseAuth firebaseAuth;

    public UserService(Context context) {
        this.context = context;
        this.userLoginValidator = new UserValidatorService(context);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void userSignIn(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context, OverviewActivity.class);
                            context.startActivity(intent);

                        } else {
                            Toast.makeText(context, "Du kunne ikke logge ind. Prøv igen", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void createUser(User user) {
        boolean isUserRegistrationValid = userLoginValidator.createUserValidator(user);
        if (isUserRegistrationValid) {
            firebaseAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                UserRepository userRepository = new UserRepository();
                                userRepository.storeUserDataInFirestoreDatabase(user);
                                redirectToWelcomeActivity(user.getUserName(), user.getAge());
                                ((Activity) context).finish();
                            } else {
                                Toast.makeText(context, "Fejl i oprettelse af bruger. Prøv igen", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void redirectToWelcomeActivity(String username, String age) {
        Intent intent = new Intent(context, WelcomeActivity.class);
        intent.putExtra("userName", username);
        intent.putExtra("age", age);
        context.startActivity(intent);
    }

}
