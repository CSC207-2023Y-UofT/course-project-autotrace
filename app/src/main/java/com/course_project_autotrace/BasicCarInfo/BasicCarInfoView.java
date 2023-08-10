package com.course_project_autotrace.BasicCarInfo;

/**
 * Interface representing the view operations in the Basic Car Info feature.
 * This allows for decoupling and provides a way to interact between the presenter and the view.
 */
public interface BasicCarInfoView {

    /**
     * Displays the car details in the view.
     *
     * @param car The car entity containing the details to be displayed.
     */
    void displayCarDetails(CarEntity.Car car);

    /**
     * Navigates the user back to the login screen.
     */
    void navigateToLoginScreen();
}
