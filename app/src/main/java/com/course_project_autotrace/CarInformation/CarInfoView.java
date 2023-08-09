package com.course_project_autotrace.CarInformation;

public interface CarInfoView {
    void displayCarInfo(String name, String model, String owner, String insuranceInfo);

    void ToHome();
    void ToTrafficViolations();
    void ToCarInfo();
    void ToProfile();
}
