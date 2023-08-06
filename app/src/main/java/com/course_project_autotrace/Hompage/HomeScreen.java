package com.course_project_autotrace.Hompage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.course_project_autotrace.CarInformation.CarInfo;
import com.course_project_autotrace.UserProfile.ProfileScreen;
import com.course_project_autotrace.R;
import com.course_project_autotrace.RegisterNewVehicle.RegisterNewVehicle;
import com.course_project_autotrace.TrafficViolations.TrafficViolations;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        ImageButton registerNewCarBtn = findViewById(R.id.AddBtn);
        registerNewCarBtn.setOnClickListener(v -> {
            Intent intent2 = new Intent(HomeScreen.this, RegisterNewVehicle.class);
            startActivity(intent2);
        });

        ImageButton carBtn = findViewById(R.id.car1Btn);
        carBtn.setOnClickListener(v -> {
            Intent intent3 = new Intent(HomeScreen.this, CarInfo.class);
            startActivity(intent3);
        });

        ImageButton violationBtn = findViewById(R.id.violationBtn);
        violationBtn.setOnClickListener(v -> {
            Intent intent3 = new Intent(HomeScreen.this, TrafficViolations.class);
            startActivity(intent3);
        });
        ImageButton profileBTN = findViewById(R.id.profileBTN);
        profileBTN.setOnClickListener(v -> {
            Intent intent3 = new Intent(HomeScreen.this, ProfileScreen.class);
            startActivity(intent3);
        });

        ImageButton CarInfoB = findViewById(R.id.CarInfoBtn);
        CarInfoB.setOnClickListener(v -> {
            Intent intent2 = new Intent(HomeScreen.this, CarInfo.class);
            startActivity(intent2);
        });

        ImageButton HomeBtn = findViewById(R.id.HomeButton);
        HomeBtn.setOnClickListener(v -> {
            Intent intent2 = new Intent(HomeScreen.this, HomeScreen.class);
            startActivity(intent2);
        });
    }

}