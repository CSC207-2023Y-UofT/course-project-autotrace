package com.course_project_autotrace.CarInformation;
public class CarInfoPresenter {

    private CarInfoModel model;
    private CarInfoView view;

    public CarInfoPresenter(CarInfoView view) {
        this.view = view;
        this.model = new CarInfoModel();
    }

    public void fetchCarInfo() {
        model.fetchCarInfo(new CarInfoModel.OnDataFetched() {
            @Override
            public void onDataReceived(String name, String model, String owner, String insuranceInfo) {
                view.displayCarInfo(name, model, owner, insuranceInfo);
            }
            @Override
            public void onError() {
                // could add error message to User
            }
        });
    }


    public void onBackButtonClicked() {
        view.ToHome();
    }

    public void onViolationButtonClicked() {
        view.ToTrafficViolations();
    }

    public void onProfileButtonClicked() {
        view.ToProfile();
    }

    public void onCarInfoButtonClicked() {
        view.ToCarInfo();
    }

    public void onHomeButtonClicked() {
        view.ToHome();
    }
}
