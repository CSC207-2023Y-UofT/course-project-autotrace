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
import com.course_project_autotrace.UserProfile.ProfileView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Represents the main activity for viewing traffic violations.
 * It fetches and displays the traffic violations associated with a specific user.
 */
public class TrafficViolations extends AppCompatActivity implements TrafficViolationsView {

    private TextView violationNameTextView, IssueTextView, FineTextView, LocationTextView;
    private TrafficViolationsPresenter presenter;
    private String DriverLicense;
    DatabaseReference referenceToUsers;
    DatabaseReference referenceToViolations;

    /**
     * Initializes the activity, sets up UI, and fetches the required data from Firebase.
     *
     * @param savedInstanceState If non-null, this activity is being re-initialized after previously
     *                           shutting down.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_violations);

        // Firebase User Initialization
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String userID = user.getUid();

        // Firebase Database References Initialization
        referenceToUsers = FirebaseDatabase.getInstance().getReference().child("UserAccountEntity");
        referenceToViolations = FirebaseDatabase.getInstance().getReference().child("TrafficViolations");

        // Fetch user's driver license from Firebase and then fetch the traffic violations
        referenceToUsers.child(userID).child("driverLicense").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    DriverLicense = dataSnapshot.getValue(String.class);
                    presenter.fetchDataForDriver(DriverLicense);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                showError("Failed to fetch driver license.");
            }
        });

        // UI Initialization
        violationNameTextView = findViewById(R.id.headingTextView);
        IssueTextView = findViewById(R.id.subheadingTextView);
        FineTextView = findViewById(R.id.amountPayable);
        LocationTextView = findViewById(R.id.descriptionTextView);

        // Navigation Button Handlers
        findViewById(R.id.BackBtn).setOnClickListener(v -> navigateTo(HomeScreen.class));
        findViewById(R.id.violationBtn).setOnClickListener(v -> navigateTo(TrafficViolations.class));
        findViewById(R.id.profileBTN).setOnClickListener(v -> navigateTo(ProfileView.class));
        findViewById(R.id.CarInfoBtn).setOnClickListener(v -> navigateTo(CarInfo.class));
        findViewById(R.id.HomeButton).setOnClickListener(v -> navigateTo(HomeScreen.class));

        // Model and Presenter Initialization
        TrafficViolationsModel model = new TrafficViolationsModel();
        presenter = new TrafficViolationsPresenter(this, model);
    }

    /**
     * Navigates to another activity.
     *
     * @param targetClass The class of the target activity to navigate to.
     */
    private void navigateTo(Class<?> targetClass) {
        Intent intent = new Intent(TrafficViolations.this, targetClass);
        startActivity(intent);
    }

    /**
     * Displays the traffic violations fetched from the database on the UI.
     *
     * @param violations The snapshot containing the traffic violation data.
     */
    @Override
    public void showTrafficViolationsData(DataSnapshot violations) {
        violationNameTextView.setText(violations.child("Violation").getValue(String.class));
        IssueTextView.setText(violations.child("Issue Date").getValue(String.class));
        FineTextView.setText(violations.child("Fine").getValue(String.class));
        LocationTextView.setText(violations.child("Location").getValue(String.class));
    }

    /**
     * Displays an error message to the user.
     *
     * @param error The error message to display.
     */
    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    /**
     * Indicates to the user that there are no traffic violations.
     */
    @Override
    public void showNoViolations() {
        //Toast.makeText(this, "No Traffic Violations Found", Toast.LENGTH_LONG).show();
    }
}
