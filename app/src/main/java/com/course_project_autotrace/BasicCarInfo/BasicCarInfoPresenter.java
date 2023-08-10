package com.course_project_autotrace.BasicCarInfo;

import android.content.Intent;

/**
 * Presenter class for the BasicCarInfo. It handles the business logic for
 * fetching and displaying basic car information, as well as navigation actions.
 */
public class BasicCarInfoPresenter {

    // The view associated with this presenter.
    private final BasicCarInfoView carView;

    // The use case for fetching car information.
    private final FetchCarInfoUseCase fetchInfoUseCase;

    /**
     * Constructs a new BasicCarInfoPresenter with the given view and use case.
     *
     * @param carView the view to be updated by this presenter.
     * @param fetchInfoUseCase the use case for fetching car information.
     */
    public BasicCarInfoPresenter(BasicCarInfoView carView, FetchCarInfoUseCase fetchInfoUseCase){
        this.carView = carView;
        this.fetchInfoUseCase = fetchInfoUseCase;
    }

    /**
     * Loads and displays car information using data from the provided intent.
     *
     * @param intent the intent containing the car data to be loaded.
     */
    public void loadCarInfo(Intent intent){
        CarEntity.Car car1 = fetchInfoUseCase.fromIntent(intent);
        carView.displayCarDetails(car1);
    }

    /**
     * Handles a back navigation action, triggering the view to navigate back to
     * the LoginScreen.
     */
    public void handleBackClicked(){
        carView.navigateToLoginScreen();
    }

}
