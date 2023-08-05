package com.course_project_autotrace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class TrafficViolations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_violations);

        ImageButton backBtn = findViewById(R.id.BackBtn);
        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(TrafficViolations.this, HomeScreen.class);
            startActivity(intent);
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
