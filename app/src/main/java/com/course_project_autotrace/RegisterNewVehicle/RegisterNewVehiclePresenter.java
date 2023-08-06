package com.course_project_autotrace.RegisterNewVehicle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;

public class RegisterNewVehiclePresenter implements RegisterNewVehicleInterface.RegisterPresenter{

    private RegisterNewVehicleInterface.View view;
    private RegisterNewVehicleModel model;

    // Constructor for the presenter class
    public RegisterNewVehiclePresenter(RegisterNewVehicleInterface.View carView, RegisterNewVehicleModel carModel){
        this.view = carView;
        this.model = carModel;
    }

    @Override
    public void registerNewVehicle(String enteredLicensePlate) {
        model.checkIfCarExists(enteredLicensePlate, new RegisterNewVehicleModel.OnCarDatabaseCheckListener() {
            @Override
            public void OnCarExistInDB(DataSnapshot dataSnapshot) {
                String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
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
