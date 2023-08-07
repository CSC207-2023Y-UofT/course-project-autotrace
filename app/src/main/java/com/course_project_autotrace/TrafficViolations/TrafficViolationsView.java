// TrafficViolationsView.java
package com.course_project_autotrace.TrafficViolations;

import com.google.firebase.database.DataSnapshot;

public interface TrafficViolationsView {
    void showTrafficViolationsData(DataSnapshot violations);
    void showError(String error);
    void showNoViolations();
}
