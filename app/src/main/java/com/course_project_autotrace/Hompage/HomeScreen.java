package com.course_project_autotrace.Hompage;

import androidx.appcompat.app.AppCompatActivity;
import com.course_project_autotrace.CarInformation.CarInfo;
import com.course_project_autotrace.UserProfile.ProfileView;
import com.course_project_autotrace.RegisterNewVehicle.RegisterNewVehicle;
import com.course_project_autotrace.TrafficViolations.TrafficViolations;
import android.widget.ImageButton;
import android.content.Intent;
import android.os.Bundle;
import com.course_project_autotrace.R;


public class HomeScreen extends AppCompatActivity implements HomeScreenView {
    private HomeScreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        presenter = new HomeScreenPresenter(this);

        ImageButton registerNewCarBtn = findViewById(R.id.AddBtn);
        registerNewCarBtn.setOnClickListener(v -> presenter.onRegisterNewCarBtnClicked());

        ImageButton carBtn = findViewById(R.id.car1Btn);
        carBtn.setOnClickListener(v -> presenter.onCarBtnClicked());

        // Navigation

        ImageButton violationBtn = findViewById(R.id.violationBtn);
        violationBtn.setOnClickListener(v -> presenter.onViolationBtnClicked());

        ImageButton profileBTN = findViewById(R.id.profileBTN);
        profileBTN.setOnClickListener(v -> presenter.onProfileBtnClicked());

        ImageButton CarInfoB = findViewById(R.id.CarInfoBtn);
        CarInfoB.setOnClickListener(v -> presenter.onCarInfoBtnClicked());

        ImageButton HomeBtn = findViewById(R.id.HomeButton);
        HomeBtn.setOnClickListener(v -> presenter.onHomeBtnClicked());
    }

    @Override
    public void ToRegisterNewVehicle() {
        Intent intent = new Intent(HomeScreen.this, RegisterNewVehicle.class);
        startActivity(intent);
    }

    @Override
    public void ToHomeScreen() {
        Intent intent = new Intent(HomeScreen.this, HomeScreen.class);
        startActivity(intent);
    }
    @Override
    public void ToTrafficViolations() {
        Intent intent = new Intent(HomeScreen.this, TrafficViolations.class);
        startActivity(intent);
    }
    @Override
    public void ToCarInfo() {
        Intent intent = new Intent(HomeScreen.this, CarInfo.class);
        startActivity(intent);
    }

    @Override
    public void ToProfileView() {
        Intent intent = new Intent(HomeScreen.this, ProfileView.class);
        startActivity(intent);
    }

    @Override
    public void oRegisterNewVehicle() {

    }
}
