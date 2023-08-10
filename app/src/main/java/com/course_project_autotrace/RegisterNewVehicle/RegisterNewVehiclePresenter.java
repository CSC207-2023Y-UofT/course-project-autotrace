package com.course_project_autotrace.RegisterNewVehicle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;

import java.util.Objects;

/**
 * This class represents the presenter for the Register New Vehicle functionality.
 * It acts as an intermediary between the View (UI) and the Model (Data operations),
 * responding to UI interactions and updating the UI as required.
 */
public class RegisterNewVehiclePresenter implements RegisterNewVehicleInterface.RegisterPresenter{

    private final RegisterNewVehicleInterface.View view;
    private final RegisterNewVehicleModel model;

    /**
     * Constructor for the presenter class.
     *
     * @param carView Represents the interface to the View (UI) for registering a new vehicle.
     * @param carModel Represents the Model handling data operations for registering a new vehicle.
     */
    public RegisterNewVehiclePresenter(RegisterNewVehicleInterface.View carView, RegisterNewVehicleModel carModel){
        this.view = carView;
        this.model = carModel;
    }

    /**
     * Handles the registration of a new vehicle based on its license plate. It checks if the vehicle
     * exists in the database, and if it does, it associates the vehicle with the logged-in user.
     *
     * @param enteredLicensePlate The license plate of the vehicle to be registered.
     */
    @Override
    public void registerNewVehicle(String enteredLicensePlate) {
        model.checkIfCarExists(enteredLicensePlate, new RegisterNewVehicleModel.OnCarDatabaseCheckListener() {
            @Override
            public void OnCarExistInDB(DataSnapshot dataSnapshot) {
                String userID = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
                model.addCarForUserInDB(userID, dataSnapshot, new RegisterNewVehicleModel.OnDatabaseUpdateListener() {
                    @Override
                    public void onSuccess() {
                        view.onCarAddSuccess();
                    }

                    @Override
                    public void onFailure() {
                        view.onCarAddFailure();
                    }
                });
            }

            @Override
            public void onCarNotExistInDB() {
                view.onCarNotExistInDB();
            }
        });
    }
}
