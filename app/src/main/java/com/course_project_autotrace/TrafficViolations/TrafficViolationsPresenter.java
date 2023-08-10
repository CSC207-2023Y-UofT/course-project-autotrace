package com.course_project_autotrace.TrafficViolations;

import com.google.firebase.database.DataSnapshot;

/**
 * Represents the presenter for the Traffic Violations feature.
 * The presenter handles the business logic of fetching and presenting traffic violations data.
 */
public class TrafficViolationsPresenter {

    private final TrafficViolationsModel model;
    private final TrafficViolationsView view;

    /**
     * Constructor for the TrafficViolationsPresenter.
     *
     * @param view  The view interface that this presenter will update.
     * @param model The model that this presenter will use to fetch data.
     */
    public TrafficViolationsPresenter(TrafficViolationsView view, TrafficViolationsModel model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Fetches the traffic violations data for the specified driver license.
     * Once the data is fetched, the presenter updates the view accordingly.
     *
     * @param driverLicense The driver license for which to fetch the traffic violations data.
     */
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
