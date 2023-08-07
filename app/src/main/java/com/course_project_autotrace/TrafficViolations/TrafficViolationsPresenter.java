package com.course_project_autotrace.TrafficViolations;

import com.google.firebase.database.DataSnapshot;

public class TrafficViolationsPresenter {

    private final TrafficViolationsModel model;
    private final TrafficViolationsView view;

    public TrafficViolationsPresenter(TrafficViolationsView view, TrafficViolationsModel model) {
        this.view = view;
        this.model = model;
    }

    public void fetchDataForDriver(String driverLicense) {
        model.fetchViolationsData(driverLicense, new TrafficViolationsModel.OnDataLoaded() {
            @Override
            public void onDataLoaded(DataSnapshot violations) {
                if (violations != null) {
                    view.showTrafficViolationsData(violations);
                } else {
                    view.showNoViolations();
                }
            }

            @Override
            public void onError(String error) {
                view.showError(error);
            }
        });
    }
}
