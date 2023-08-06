package com.course_project_autotrace.ForgotPassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.course_project_autotrace.Login.LoginScreen;
import com.course_project_autotrace.R;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword1 extends AppCompatActivity {
    Button btnResetContinue;
    EditText edtEmail;
    //ProgressBar progressBar;
    FirebaseAuth mAuth;
    String strEmail;
    ImageButton bckButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password1);
        //declare
        btnResetContinue = findViewById(R.id.btnResetPwdContinue);
        edtEmail = findViewById(R.id.editTextEmail);
        //progressbar = ..
        mAuth = FirebaseAuth.getInstance();
        bckButton = findViewById(R.id.BackBtn);

        //listener.
        btnResetContinue.setOnClickListener(view -> {
            strEmail = edtEmail.getText().toString().trim();
            if (!TextUtils.isEmpty(strEmail)) {
                ResetPassword();
            } else {
                edtEmail.setError("Enter the Email");
            }

        });
        bckButton.setOnClickListener(v-> {

            //  code for Forgotpassword clicked
            Intent intent = new Intent(ForgotPassword1.this, LoginScreen.class);
            startActivity(intent);

        });


    }

    //can be refactored by design principle/pattern.
    private void ResetPassword() {
        btnResetContinue.setVisibility(View.INVISIBLE);
        mAuth.sendPasswordResetEmail(strEmail)
                .addOnSuccessListener(unused -> {
                    // Reset email sent successfully. Handle your success case here if needed.
                    Toast.makeText(ForgotPassword1.this,"Reset Password Link has been sent to your registered Email",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ForgotPassword1.this, LoginScreen.class);
                    startActivity(intent);
                    finish();
                })
                .addOnFailureListener(e -> {
                    // Handle your failure case here if needed.
                    Toast.makeText(ForgotPassword1.this, "Error:-"+ e.getMessage(), Toast.LENGTH_SHORT).show();


                });
        btnResetContinue.setVisibility(View.VISIBLE);
    }
}
