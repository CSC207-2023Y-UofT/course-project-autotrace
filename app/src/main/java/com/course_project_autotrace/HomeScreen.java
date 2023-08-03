package com.course_project_autotrace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ImageButton backBtn = findViewById(R.id.BackBtn);
        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeScreen.this, RegisterNewVehicle.class);
            startActivity(intent);
        });
        ImageButton basicCarInfoBtn = findViewById(R.id.CarInfoBtn);
        basicCarInfoBtn.setOnClickListener(v -> {
            Intent intent2 = new Intent(HomeScreen.this, BasicCarInfo.class);
            startActivity(intent2);
        });

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
    }

}