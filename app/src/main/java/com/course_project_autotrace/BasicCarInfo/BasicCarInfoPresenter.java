package com.course_project_autotrace.BasicCarInfo;

import android.content.Intent;

public class BasicCarInfoPresenter {

    // variable for presenter class
    private final BasicCarInfoView carView;
    private final FetchCarInfoUseCase fetchInfoUseCase;

    // Constructor for BasicCarInfoFectchPresenter
    public BasicCarInfoPresenter(BasicCarInfoView carView, FetchCarInfoUseCase fetchInfoUseCase){
        this.carView = carView;
        this.fetchInfoUseCase = fetchInfoUseCase;
    }

    // Load the car info method
    public void loadCarInfo(Intent intent){
        CarEntity.Car car1 = fetchInfoUseCase.fromIntent(intent);
        carView.displayCarDetails(car1);
    }

    // method to navigate back to the LoginScreen
    public void handleBackClicked(){
        carView.navigateToLoginScreen();
    }

}
