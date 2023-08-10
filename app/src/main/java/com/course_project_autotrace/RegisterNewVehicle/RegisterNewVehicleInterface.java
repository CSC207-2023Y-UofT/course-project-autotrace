package com.course_project_autotrace.RegisterNewVehicle;

/**
 * Defines the contract between the View and the Presenter for the RegisterNewVehicle functionality.
 */
public interface RegisterNewVehicleInterface {

    /**
     * Represents the View in the MVP architecture for the RegisterNewVehicle functionality.
     */
    interface View {

        /**
         * Notifies the user when a car is successfully added.
         */
        void onCarAddSuccess();

        /**
         * Notifies the user when there's a failure in adding the car.
         */
        void onCarAddFailure();

        /**
         * Notifies the user when the entered car does not exist in the database.
         */
        void onCarNotExistInDB();
    }

    /**
     * Represents the Presenter in the MVP architecture for the RegisterNewVehicle functionality.
     */
    interface RegisterPresenter {

        /**
         * Initiates the process of registering a new vehicle.
         *
         * @param enteredLicensePlateNum The license plate number entered by the user.
         */
        void registerNewVehicle(String enteredLicensePlateNum);
    }
}
