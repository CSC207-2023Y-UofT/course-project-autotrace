package com.course_project_autotrace.BasicCarInfo;

public class CarEntity {
    public static class Car {
        // Variables for basic information to be presented on the screen
        private String modelYear, vehicleName, info, insurance;

        // Constructor for Car
        public Car(String vehicleName, String modelYear, String info, String insurance){
            this.vehicleName = vehicleName;
            this.modelYear = modelYear;
            this.info = info;
            this.insurance = insurance;
        }

        public String getModel() {
            return modelYear;
        }

        public String getName() {
            return vehicleName;
        }

        public String getInsurance() {
            return insurance;
        }

        public String getInfo() {
            return info;
        }
    }
}
