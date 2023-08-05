package com.course_project_autotrace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class TrafficViolations extends AppCompatActivity {

    private DataSnapshot violations;
    private DatabaseReference referenceToUsers, referenceToViolations;
    private String userID;
    private String DriverLicense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_violations);
        ImageButton refreshBtn = findViewById(R.id.refreshBtn);
        TextView violationNameTextView = findViewById(R.id.headingTextView);
        TextView IssueTextView = findViewById(R.id.subheadingTextView);
        TextView FineTextView = findViewById(R.id.amountPayable);
        TextView LocationTextView = findViewById(R.id.descriptionTextView);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        userID = user.getUid();
        referenceToUsers = FirebaseDatabase.getInstance().getReference().child("UserAccount");
        referenceToViolations = FirebaseDatabase.getInstance().getReference().child("TrafficViolations");

        referenceToUsers.child(userID).child("driverLicense").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    DriverLicense = dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        refreshBtn.setOnClickListener(v -> referenceToViolations.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    if (Objects.equals(snapshot.getKey(), DriverLicense)){
                        violations = snapshot;
                    }
                }

                if (violations != null) {
                    // Set the retrieved data
                    violationNameTextView.setText(violations.child("Violation").getValue(String.class));
                    IssueTextView.setText(violations.child("Issue Date").getValue(String.class));
                    FineTextView.setText(violations.child("Fine").getValue(String.class));
                    LocationTextView.setText(violations.child("Location").getValue(String.class));

                    referenceToUsers.child(userID).child("Violations").child(Objects.requireNonNull(violations.getKey())).setValue(violations.getValue()).addOnSuccessListener(aVoid -> {
                        Toast.makeText(TrafficViolations.this, "New Traffic Violations Found", Toast.LENGTH_LONG).show();
                    }).addOnFailureListener(e -> Toast.makeText(TrafficViolations.this, "Failed to find traffic violations in the database", Toast.LENGTH_LONG).show());
                } else {
                    Toast.makeText(TrafficViolations.this, "No Traffic Violations Found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }));

        ImageButton backBtn = findViewById(R.id.BackBtn);
        backBtn.setOnClickListener(v -> {
            Intent intent2 = new Intent(TrafficViolations.this, TrafficViolations.class);
            startActivity(intent2);
        });

        ImageButton violationBtn = findViewById(R.id.violationBtn);
        violationBtn.setOnClickListener(v -> {
            Intent intent3 = new Intent(TrafficViolations.this, TrafficViolations.class);
            startActivity(intent3);
        });
        ImageButton profileBTN = findViewById(R.id.profileBTN);
        profileBTN.setOnClickListener(v -> {
            Intent intent3 = new Intent(TrafficViolations.this, ProfileScreen.class);
            startActivity(intent3);
        });

        ImageButton CarInfoB = findViewById(R.id.CarInfoBtn);
        CarInfoB.setOnClickListener(v -> {
            Intent intent2 = new Intent(TrafficViolations.this, CarInfo.class);
            startActivity(intent2);
        });

        ImageButton HomeBtn = findViewById(R.id.HomeButton);
        HomeBtn.setOnClickListener(v -> {
            Intent intent2 = new Intent(TrafficViolations.this, HomeScreen.class);
            startActivity(intent2);
        });

    }
}
