package com.course_project_autotrace.RegisterNewVehicle;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.course_project_autotrace.Hompage.HomeScreen;
import com.course_project_autotrace.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterNewVehicle extends AppCompatActivity implements RegisterNewVehicleInterface.View {
    private RegisterNewVehiclePresenter carPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_vehicle);


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

}
