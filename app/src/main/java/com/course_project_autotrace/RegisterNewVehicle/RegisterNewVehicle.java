package com.course_project_autotrace.RegisterNewVehicle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.course_project_autotrace.Hompage.HomeScreen;
import com.course_project_autotrace.R;

/**
 * Activity class that provides the functionality to register a new vehicle.
 */
public class RegisterNewVehicle extends AppCompatActivity implements RegisterNewVehicleInterface.View {
    public RegisterNewVehiclePresenter carPresenter;


    /**
     * Initializes the activity. Sets the layout, creates click listeners for back and register buttons, and initializes the presenter.
     *
     * @param savedInstanceState Bundle object containing activity's previous state, if it exists.
     */
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

    /**
     * Displays a toast indicating the successful addition of a car and navigates to the home screen.
     */
    @Override
    public void onCarAddSuccess(){
        Toast.makeText(this, "Car added successfully", Toast.LENGTH_LONG).show();
        Intent newIntent = new Intent(RegisterNewVehicle.this, HomeScreen.class);
        startActivity(newIntent);
        finish();
    }

    /**
     * Displays a toast indicating the failure to add a car.
     */
    @Override
    public void onCarAddFailure(){
        Toast.makeText(this, "Failed to add the car", Toast.LENGTH_LONG).show();
    }

    /**
     * Displays a toast indicating that the car does not exist in the database.
     */
    @Override
    public void onCarNotExistInDB() {
        Toast.makeText(this, "Car does not exist in the database", Toast.LENGTH_LONG).show();
    }
    public void setPresenter(RegisterNewVehiclePresenter mockPresenter) {
        this.carPresenter = mockPresenter;
    }

}
