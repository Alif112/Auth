package com.example.auth.util;

import android.util.Patterns;
import android.widget.EditText;

public class Utility {
    public static boolean emailValidation(String email, EditText editTextEmail){
        if(email.isEmpty()){
            editTextEmail.setError("Email is Empty");
            editTextEmail.requestFocus();
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Invalid Email");
            editTextEmail.requestFocus();
            return false;
        }


        return true;
    }
}
