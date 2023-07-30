package com.course_project_autotrace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterNewVehicle extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private Button registerVehicleBtn;
    private EditText licensePlate, lastName, DOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_vehicle);
        ImageButton backBtn = findViewById(R.id.BackBtn);
        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterNewVehicle.this, HomeScreen.class);
            startActivity(intent);
        });
        ImageButton homeBtn = findViewById(R.id.HomeBtn);
        homeBtn.setOnClickListener(v -> {
            Intent intent2 = new Intent(RegisterNewVehicle.this, HomeScreen.class);
            startActivity(intent2);
        });


        mDatabase = FirebaseDatabase.getInstance().getReference("Users").child("1");

        registerVehicleBtn = findViewById(R.id.RegisterBtn);
        licensePlate = findViewById(R.id.LicensePlate);
        lastName = findViewById(R.id.LastName);
        DOB = findViewById(R.id.DOB);

        // Writing Data to Firebase

        registerVehicleBtn.setOnClickListener(v -> mDatabase.setValue(lastName.getText().toString()));

    }

}