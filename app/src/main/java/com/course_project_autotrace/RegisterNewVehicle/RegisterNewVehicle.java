package com.course_project_autotrace.RegisterNewVehicle;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.course_project_autotrace.CarInformation.CarInfo;
import com.course_project_autotrace.ForgotPassword.ForgotPassword1;
import com.course_project_autotrace.Hompage.HomeScreen;
import com.course_project_autotrace.Login.LoginScreen;
import com.course_project_autotrace.R;



public class RegisterNewVehicle extends AppCompatActivity implements RegisterNewVehicleInterface.View {
    public RegisterNewVehiclePresenter carPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_vehicle);

        ImageButton backBtn = findViewById(R.id.BackBtn);
        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterNewVehicle.this, HomeScreen.class);
            startActivity(intent);
        });


        Button registerVehicleBtn = findViewById(R.id.RegisterBtn);
        EditText licensePlate = findViewById(R.id.LicensePlate);

        carPresenter = new RegisterNewVehiclePresenter(this, new RegisterNewVehicleModel());

        registerVehicleBtn.setOnClickListener(v -> {
            String enteredLicensePlate = licensePlate.getText().toString();
            carPresenter.registerNewVehicle(enteredLicensePlate);

        });
    }


    @Override
    public void onCarAddSuccess(){
        Toast.makeText(this, "Car added successfully", Toast.LENGTH_LONG).show();
        Intent newIntent = new Intent(RegisterNewVehicle.this, HomeScreen.class);
        startActivity(newIntent);
        finish();
    }

    @Override
    public void onCarAddFailure(){
        Toast.makeText(this, "Failed to add the car", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onCarNotExistInDB() {
        Toast.makeText(this, "Car does not exist in the database", Toast.LENGTH_LONG).show();

    }
    public void setPresenter(RegisterNewVehiclePresenter mockPresenter) {
        this.carPresenter = mockPresenter;
    }



}
