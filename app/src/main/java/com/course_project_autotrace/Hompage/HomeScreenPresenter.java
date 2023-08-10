package com.course_project_autotrace.Hompage;

public class HomeScreenPresenter {

    private final HomeScreenView view;

    public HomeScreenPresenter(HomeScreenView view) {
        this.view = view;
    }

    public void onRegisterNewCarBtnClicked() {
        view.ToRegisterNewVehicle();
    }

    public void onCarBtnClicked() {
        view.ToCarInfo();
    }

    public void onViolationBtnClicked() {
        view.ToTrafficViolations();
    }

    public void onProfileBtnClicked() {
        view.ToProfileView();
    }

    public void onCarInfoBtnClicked() {
        view.ToCarInfo();
    }

    public void onHomeBtnClicked() {
        view.ToHomeScreen();
    }
}
