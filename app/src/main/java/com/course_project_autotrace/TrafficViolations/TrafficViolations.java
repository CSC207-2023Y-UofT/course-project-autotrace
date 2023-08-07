package com.course_project_autotrace.TrafficViolations;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.course_project_autotrace.CarInformation.CarInfo;
import com.course_project_autotrace.Hompage.HomeScreen;
import com.course_project_autotrace.R;
import com.course_project_autotrace.UserProfile.ProfileScreen;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TrafficViolations extends AppCompatActivity implements TrafficViolationsView {

    private TextView violationNameTextView, IssueTextView, FineTextView, LocationTextView;
    private TrafficViolationsPresenter presenter;
    private String DriverLicense;
    DatabaseReference referenceToUsers;
    DatabaseReference referenceToViolations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_violations);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String userID = user.getUid();
        referenceToUsers = FirebaseDatabase.getInstance().getReference().child("UserAccount");
        referenceToViolations = FirebaseDatabase.getInstance().getReference().child("TrafficViolations");

        referenceToUsers.child(userID).child("driverLicense").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    DriverLicense = dataSnapshot.getValue(String.class);
                    // Once DriverLicense is fetched, you can use it to fetch traffic violations.
                    presenter.fetchDataForDriver(DriverLicense);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle the error
                showError("Failed to fetch driver license.");
            }
        });


        // UI Initialization
        violationNameTextView = findViewById(R.id.headingTextView);
        IssueTextView = findViewById(R.id.subheadingTextView);
        FineTextView = findViewById(R.id.amountPayable);
        LocationTextView = findViewById(R.id.descriptionTextView);


        // Navigation Buttons Handlers
        findViewById(R.id.BackBtn).setOnClickListener(v -> navigateTo(TrafficViolations.class));
        findViewById(R.id.violationBtn).setOnClickListener(v -> navigateTo(TrafficViolations.class));
        findViewById(R.id.profileBTN).setOnClickListener(v -> navigateTo(ProfileScreen.class));
        findViewById(R.id.CarInfoBtn).setOnClickListener(v -> navigateTo(CarInfo.class));
        findViewById(R.id.HomeButton).setOnClickListener(v -> navigateTo(HomeScreen.class));

        // Model and Presenter Initialization
        TrafficViolationsModel model = new TrafficViolationsModel();
        presenter = new TrafficViolationsPresenter(this, model);

        // Fetch data
        presenter.fetchDataForDriver(DriverLicense);
    }

    private void navigateTo(Class<?> targetClass) {
        Intent intent = new Intent(TrafficViolations.this, targetClass);
        startActivity(intent);
    }

    @Override
    public void showTrafficViolationsData(DataSnapshot violations) {
        violationNameTextView.setText(violations.child("Violation").getValue(String.class));
        IssueTextView.setText(violations.child("Issue Date").getValue(String.class));
        FineTextView.setText(violations.child("Fine").getValue(String.class));
        LocationTextView.setText(violations.child("Location").getValue(String.class));
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNoViolations() {
        //Toast.makeText(this, "No Traffic Violations Found", Toast.LENGTH_LONG).show();
    }
}
