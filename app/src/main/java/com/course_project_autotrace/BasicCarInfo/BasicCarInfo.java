package com.course_project_autotrace.BasicCarInfo;

import android.content.Intent;
import com.course_project_autotrace.Login.LoginScreen;
import com.course_project_autotrace.R;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;


public class BasicCarInfo extends AppCompatActivity implements BasicCarInfoView {
    private BasicCarInfoPresenter BasicPresenter;
    private TextView infoBoxTextView, carNameTextview, modelYearTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_basic_car_info));

        // link the textviews with the respective ids from the resource xml
        modelYearTextView = findViewById(R.id.ModelYear);
        carNameTextview = findViewById(R.id.CarName);
        infoBoxTextView = findViewById(R.id.InfoBox);

        // Fetch the car info
        FetchCarInfoUseCase fetchInfoUseCase = new FetchCarInfoUseCase();
        BasicPresenter = new BasicCarInfoPresenter(this, fetchInfoUseCase);
        BasicPresenter.loadCarInfo(getIntent());

        // back button to navigate back to the LoginScreen
        ImageButton BackBtn = findViewById(R.id.BackBtn);
        BackBtn.setOnClickListener(v -> BasicPresenter.handleBackClicked());
    }

    @Override
    public void displayCarDetails(CarEntity.Car car) {
        modelYearTextView.setText(car.getModel());
        carNameTextview.setText(car.getName());

        String InfoFormat = String.format("%s : %s", car.getInsurance(), car.getInfo());
        infoBoxTextView.setText(InfoFormat);
    }

    @Override
    public void navigateToLoginScreen() {
        Intent newIntent = new Intent(BasicCarInfo.this, LoginScreen.class);
        startActivity(newIntent);

    }
}