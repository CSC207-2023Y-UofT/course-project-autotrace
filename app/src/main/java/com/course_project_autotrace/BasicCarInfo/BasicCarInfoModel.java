package com.course_project_autotrace.BasicCarInfo;

import android.content.Intent;

import com.course_project_autotrace.Entities.CarEntity;
import com.course_project_autotrace.Login.LoginScreen;
import com.course_project_autotrace.R;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * An activity class that displays basic car information to the user.
 * It retrieves the car details, displays them, and provides a way
 * to navigate back to the Login screen.
 */
public class BasicCarInfoModel extends AppCompatActivity implements BasicCarInfoView {

    private BasicCarInfoPresenter BasicPresenter;
    private TextView infoBoxTextView, carNameTextview, modelYearTextView;

    /**
     * Called when the activity is starting.
     * Sets the content view and initializes UI components.
     *
     * @param savedInstanceState if the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
     * recently supplied in onSaveInstanceState(Bundle). Otherwise, it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_basic_car_info));

        // Link the TextViews with the respective IDs from the resource XML
        modelYearTextView = findViewById(R.id.ModelYear);
        carNameTextview = findViewById(R.id.CarName);
        infoBoxTextView = findViewById(R.id.InfoBox);

        // Fetch and display the car info
        FetchCarInfoUseCase fetchInfoUseCase = new FetchCarInfoUseCase();
        BasicPresenter = new BasicCarInfoPresenter(this, fetchInfoUseCase);
        BasicPresenter.loadCarInfo(getIntent());

        // Set up a back button to navigate back to the LoginScreen
        ImageButton BackBtn = findViewById(R.id.BackBtn);
        BackBtn.setOnClickListener(v -> BasicPresenter.handleBackClicked());
    }

    /**
     * Displays car details including model, name, insurance, and additional info.
     *
     * @param car the car entity containing the details to be displayed.
     */
    @Override
    public void displayCarDetails(CarEntity.Car car) {
        modelYearTextView.setText(car.getModel());
        carNameTextview.setText(car.getName());

        String InfoFormat = String.format("%s : %s", car.getInsurance(), car.getInfo());
        infoBoxTextView.setText(InfoFormat);
    }

    /**
     * Navigates the user to the LoginScreen activity.
     */
    @Override
    public void navigateToLoginScreen() {
        Intent newIntent = new Intent(BasicCarInfoModel.this, LoginScreen.class);
        startActivity(newIntent);
    }
}
