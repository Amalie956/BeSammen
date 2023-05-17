package com.example.besammen.domain;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

public class UserValidator {
    private Context context;

    public UserValidator(Context context) {
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

    public boolean createUserValidator(String email, String password) {
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

}
