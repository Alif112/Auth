package com.example.auth.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.auth.R;
import com.example.auth.util.Utility;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener{
    private EditText editTextEmail;
    private Button buttonSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        editTextEmail=(EditText) findViewById(R.id.email);
        buttonSendEmail=(Button) findViewById(R.id.sendEmail);
        buttonSendEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sendEmail:
                sendEmailForResetPassword();
                break;
        }
    }

    private void sendEmailForResetPassword() {
        String email=editTextEmail.getText().toString().trim();
        if(Utility.emailValidation(email,editTextEmail)){
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ForgotPassword.this,"Check your email to reset password",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }else return;



    }
}