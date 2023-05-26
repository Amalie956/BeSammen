package com.example.besammen.domain;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

public class UserValidatorService {
    private Context context;

    public UserValidatorService(Context context) {
        this.context = context;
    }

    public boolean loginValidator(String email, String password) {
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(context, "Indtast venligst din email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "Indtast venligst dit kodeord", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean createUserValidator(User user) {
        if (TextUtils.isEmpty(user.getEmail())) {
            Toast.makeText(context, "Indtast venligst din email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(user.getPassword())) {
            Toast.makeText(context, "Indtast venligst dit kodeord", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(user.getUserName())) {
            Toast.makeText(context, "Indtast venligst dit brugernavn", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(user.getAge())) {
            Toast.makeText(context, "Indtast venligst din alder", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(user.getGender())) {
            Toast.makeText(context, "Indtast venligst dit køn", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(user.getDiagnosis())) {
            Toast.makeText(context, "Indtast venligst din diagnose", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }

}
