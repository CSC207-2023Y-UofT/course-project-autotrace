package com.course_project_autotrace.CarInformation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import com.course_project_autotrace.Hompage.HomeScreen;
import com.course_project_autotrace.R;
import com.course_project_autotrace.TrafficViolations.TrafficViolations;
import com.course_project_autotrace.UserProfile.ProfileScreen;

public class CarInfo extends AppCompatActivity implements CarInfoView {

    private CarInfoPresenter presenter;
    private TextView CarNameTextView, modelYearTextView, NameTextView, insuranceTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info);

        presenter = new CarInfoPresenter(this);

        // Fetching car info
        presenter.fetchCarInfo();

        // Initializing the views
        CarNameTextView = findViewById(R.id.textView2);
        modelYearTextView = findViewById(R.id.ModelYear);
        NameTextView = findViewById(R.id.Name);
        insuranceTextView = findViewById(R.id.InsuranceInfo);

        ImageButton backBtn = findViewById(R.id.BackBtn);
        backBtn.setOnClickListener(v -> presenter.onBackButtonClicked());

        ImageButton violationBtn = findViewById(R.id.violationBtn);
        violationBtn.setOnClickListener(v -> presenter.onViolationButtonClicked());

        ImageButton profileBTN = findViewById(R.id.profileBTN);
        profileBTN.setOnClickListener(v -> presenter.onProfileButtonClicked());

        ImageButton CarInfoB = findViewById(R.id.CarInfoBtn);
        CarInfoB.setOnClickListener(v -> presenter.onCarInfoButtonClicked());

        ImageButton HomeBtn = findViewById(R.id.HomeButton);
        HomeBtn.setOnClickListener(v -> presenter.onHomeButtonClicked());
    }


    @Override
    public void displayCarInfo(String name, String model, String owner, String insuranceInfo) {
        CarNameTextView.setText(name);
        modelYearTextView.setText(model);
        NameTextView.setText(owner);
        insuranceTextView.setText(insuranceInfo);
    }

    // Navigation

    @Override
    public void ToHome() {
        Intent intent = new Intent(CarInfo.this, HomeScreen.class);
        startActivity(intent);
    }

    @Override
    public void ToTrafficViolations() {
        Intent intent = new Intent(CarInfo.this, TrafficViolations.class);
        startActivity(intent);
    }

    @Override
    public void ToProfile() {
        Intent intent = new Intent(CarInfo.this, ProfileScreen.class);
        startActivity(intent);
    }

    @Override
    public void ToCarInfo() {
        Intent intent = new Intent(CarInfo.this, CarInfo.class);
        startActivity(intent);
    }
}
