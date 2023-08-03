package com.course_project_autotrace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileScreen extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Get a reference to the TextView
        userEmail = findViewById(R.id.userEmail);

        // Get the current authenticated user
        FirebaseUser currentUser = mAuth.getCurrentUser();

        // Set the email to the TextView if the user is signed in
        if (currentUser != null) {
            userEmail.setText(currentUser.getEmail());
        } else {
            userEmail.setText("Not signed in");
        }
    }
}