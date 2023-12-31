package com.course_project_autotrace.ForgotPassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.course_project_autotrace.Login.LoginScreen;
import com.course_project_autotrace.R;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity implements ForgotPasswordView, Observer {

    private Button btnResetContinue;
    private EditText edtEmail;
    private ImageButton bckButton;

    private ForgotPasswordPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password1);

        btnResetContinue = findViewById(R.id.btnResetPwdContinue);
        edtEmail = findViewById(R.id.editTextEmail);
        bckButton = findViewById(R.id.BackBtn);

        // Initialize presenter ,add  observer
        presenter = new ForgotPasswordPresenter(this, FirebaseAuth.getInstance());
        presenter.addObserver(this);

        btnResetContinue.setOnClickListener(v -> {
            String Email = edtEmail.getText().toString().trim();
            presenter.CheckForgotPassword(Email);
        });

        bckButton.setOnClickListener(v -> presenter.handleBack());
    }

    @Override
    public void ShowEmptyError() {
        edtEmail.setError("Enter the Email");
    }

    @Override
    public void BackToLogin() {
        Intent intent = new Intent(ForgotPassword.this, LoginScreen.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void ShowResetPasswordSuccess() {
        Toast.makeText(ForgotPassword.this, "Reset Password Link has been sent to your registered Email", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShowResetPasswordFailed() {
        Toast.makeText(ForgotPassword.this,"Reseting Password Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void update(String notification) {
        if ("success".equals(notification)) {
            ShowResetPasswordSuccess();
        } else if ("failed".equals(notification)) {
            ShowResetPasswordFailed();
        }
    }
}



