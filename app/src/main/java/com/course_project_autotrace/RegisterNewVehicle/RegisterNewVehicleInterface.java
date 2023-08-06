package com.course_project_autotrace.RegisterNewVehicle;

public interface RegisterNewVehicleInterface {

    interface View {
        void onCarAddSuccess();
        void onCarAddFailure();
        void onCarNotExistInDB();
    }
    interface RegisterPresenter {
        void registerNewVehicle(String enteredLicensePlateNum);
    }
}