package com.course_project_autotrace;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileScreen extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
        ImageButton backBtn = findViewById(R.id.BackBtn);
        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileScreen.this, HomeScreen.class);
            startActivity(intent);
        });
        Button logoutBtn = findViewById(R.id.buttonLogout);
        logoutBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileScreen.this, LogInScreen.class);
            startActivity(intent);
        });
        Button editBtn = findViewById(R.id.buttonProfileInformation);
        editBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileScreen.this, EditProfileScreen.class);
            startActivity(intent);
        });
        Button rateBtn = findViewById(R.id.buttonRateUs);
        rateBtn.setOnClickListener(v -> {
            // Open apple.com in a web browser
            String appleUrl = "https://github.com/CSC207-2023Y-UofT/course-project-autotrace";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(appleUrl));
            startActivity(intent);
        });
        // Initialize Firebase Auth
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        // Get a reference to the TextView
        TextView userEmail = findViewById(R.id.userEmail);

        // Get the current authenticated user
        FirebaseUser currentUser = mAuth.getCurrentUser();

        // Set the email to the TextView if the user is signed in
        if (currentUser != null) {
            userEmail.setText(currentUser.getEmail());
        } else {
            userEmail.setText("Not logged in.");
        }
        ImageButton violationBtn = findViewById(R.id.violationBtn);
        violationBtn.setOnClickListener(v -> {
            Intent intent3 = new Intent(ProfileScreen.this, TrafficViolations.class);
            startActivity(intent3);
        });
        ImageButton profileBTN = findViewById(R.id.profileBTN);
        profileBTN.setOnClickListener(v -> {
            Intent intent3 = new Intent(ProfileScreen.this, ProfileScreen.class);
            startActivity(intent3);
        });

        ImageButton CarInfoB = findViewById(R.id.CarInfoBtn);
        CarInfoB.setOnClickListener(v -> {
            Intent intent2 = new Intent(ProfileScreen.this, CarInfo.class);
            startActivity(intent2);
        });

        ImageButton HomeBtn = findViewById(R.id.HomeButton);
        HomeBtn.setOnClickListener(v -> {
            Intent intent2 = new Intent(ProfileScreen.this, HomeScreen.class);
            startActivity(intent2);
        });
    }
}