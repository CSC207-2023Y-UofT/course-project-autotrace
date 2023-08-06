package com.course_project_autotrace.UserProfile;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.course_project_autotrace.CarInformation.CarInfo;
import com.course_project_autotrace.Hompage.HomeScreen;
import com.course_project_autotrace.Login.LoginScreen;
import com.course_project_autotrace.R;
import com.course_project_autotrace.TrafficViolations.TrafficViolations;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(ProfileScreen.this, LoginScreen.class);
            startActivity(intent);
            finish(); // Close the profile screen after logging out
            Toast.makeText(ProfileScreen.this,"Logout succefully",Toast.LENGTH_SHORT).show();
        });
        Button editBtn = findViewById(R.id.buttonProfileInformation);
        editBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileScreen.this, EditProfileScreen.class);
            startActivity(intent);
        });
        Button rateBtn = findViewById(R.id.buttonRateUs);
        rateBtn.setOnClickListener(v -> {
            // Open GitHub link in a web browser
            String githubUrl = "https://github.com/CSC207-2023Y-UofT/course-project-autotrace";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl));
            startActivity(intent);
        });

        // Initialize Firebase Auth
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        // Get a reference to the TextViews
        TextView userEmail = findViewById(R.id.userEmail);
        TextView userName = findViewById(R.id.userName);

        // Get the current authenticated user
        FirebaseUser currentUser = mAuth.getCurrentUser();

        // Set the email to the TextView if the user is signed in
        if (currentUser != null) {
            userEmail.setText(currentUser.getEmail());
            // Get and set the username from the database
            fetchAndSetUserName(currentUser.getUid(), userName);
        } else {
            userEmail.setText("Not logged in.");
            userName.setText("");
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

    private void fetchAndSetUserName(String userId, TextView userNameTextView) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("UserAccount");
        databaseReference.child(userId).child("fullName").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String userName = dataSnapshot.getValue(String.class);
                userNameTextView.setText(userName);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle any errors that may occur during the database operation
                userNameTextView.setText("Error fetching username");
            }
        });
    }
}
