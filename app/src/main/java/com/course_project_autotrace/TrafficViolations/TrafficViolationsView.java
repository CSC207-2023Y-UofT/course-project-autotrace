// TrafficViolationsView.java
package com.course_project_autotrace.TrafficViolations;

import com.google.firebase.database.DataSnapshot;

/**
 * Interface representing the View in MVP architecture for Traffic Violations feature.
 * Provides necessary methods to display traffic violations data, errors, and absence of violations.
 */
public interface TrafficViolationsView {

    /**
     * Displays the traffic violations data to the user.
     *
     * @param violations DataSnapshot containing the traffic violations data.
     */
    void showTrafficViolationsData(DataSnapshot violations);

    /**
     * Displays an error message to the user.
     *
     * @param error Error message to be displayed.
     */
    void showError(String error);

    /**
     * Notifies the user that no traffic violations were found.
     */
    void showNoViolations();
}
