package com.course_project_autotrace.SignupMVP;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.course_project_autotrace.Login.LoginScreen;
import com.course_project_autotrace.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity implements SignupView {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private EditText mEtEmail, mEtPwd, mName;
    private SignupPresenter presenter;
    private  SignupView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize FirebaseAuth,View, and Dbref
        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();
        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_password);
        mName = findViewById(R.id.fullName);
        Button mbtnSignupContinue = findViewById(R.id.SignupContinue);

        // Initialize Presenter
        presenter = new SignupPresenter(this);


        mbtnSignupContinue.setOnClickListener(v -> {
            String email = mEtEmail.getText().toString();
            String password = mEtPwd.getText().toString();
            String name = mName.getText().toString();
            presenter.CheckSignup(email, password, name, mFirebaseAuth, mDatabaseRef);
        });
        ImageButton backBtn = findViewById(R.id.BackBtn);
        backBtn.setOnClickListener(v ->presenter.LinkToLogin());
    }

    @Override
    public void BackToLogin() {
        Intent intent = new Intent(Signup.this, LoginScreen.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void ShowSignupSuccess() {
        Toast.makeText(Signup.this, "Signup Successful :)", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShowSignupFailed() {
        Toast.makeText(Signup.this, "Signup Failed :(", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShowEmptyFieldError() {
        Toast.makeText(Signup.this, "Please fill all fields :0", Toast.LENGTH_SHORT).show();
    }
}
