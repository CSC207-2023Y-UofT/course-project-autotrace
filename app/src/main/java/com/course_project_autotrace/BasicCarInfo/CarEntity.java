package com.course_project_autotrace.BasicCarInfo;

/**
 * Entity representing car-related data structures.
 */
public class CarEntity {

    /**
     * Represents basic details of a car.
     */
    public static class Car {

        // Variables for basic information to be presented on the screen
        private final String modelYear;
        private final String vehicleName;
        private final String info;
        private final String insurance;

        /**
         * Constructor for creating a Car object.
         *
         * @param vehicleName The name of the vehicle.
         * @param modelYear   The model year of the vehicle.
         * @param info        General information or description related to the vehicle.
         * @param insurance   Insurance details of the vehicle.
         */
        public Car(String vehicleName, String modelYear, String info, String insurance){
            this.vehicleName = vehicleName;
            this.modelYear = modelYear;
            this.info = info;
            this.insurance = insurance;
        }

        /**
         * Gets the model year of the car.
         *
         * @return Model year of the car.
         */
        public String getModel() {
            return modelYear;
        }

        /**
         * Gets the name of the car.
         *
         * @return Name of the car.
         */
        public String getName() {
            return vehicleName;
        }

        /**
         * Gets the insurance details of the car.
         *
         * @return Insurance details.
         */
        public String getInsurance() {
            return insurance;
        }

        /**
         * Gets general information or description related to the vehicle.
         *
         * @return General information about the car.
         */
        public String getInfo() {
            return info;
        }
    }
}
