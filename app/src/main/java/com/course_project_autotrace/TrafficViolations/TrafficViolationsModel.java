package com.course_project_autotrace.TrafficViolations;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

/**
 * Represents the model for fetching traffic violations data.
 * It interacts with Firebase to retrieve traffic violation data associated with a specific driver license.
 */
public class TrafficViolationsModel {

    public interface OnDataLoaded {
        /**
         * Called when traffic violations data is successfully loaded.
         *
         * @param violations The snapshot containing the traffic violation data.
         */
        void onDataLoaded(DataSnapshot violations);

        /**
         * Called when there is an error while fetching data.
         *
         * @param error Error message.
         */
        void onError(String error);
    }

    private final DatabaseReference referenceToViolations;

    /**
     * Initializes the model and sets up Firebase references.
     */
    public TrafficViolationsModel() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String userID = user.getUid();

        referenceToViolations = FirebaseDatabase.getInstance().getReference().child("TrafficViolations");
    }

    /**
     * Fetches traffic violation data for the provided driver license from Firebase.
     *
     * @param driverLicense The driver license to fetch violations for.
     * @param callback      Callback to handle data loaded events.
     */
    public void fetchViolationsData(String driverLicense, OnDataLoaded callback) {
        referenceToViolations.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot violations = null;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (Objects.equals(snapshot.getKey(), driverLicense)) {
                        violations = snapshot;
                    }
                }
                callback.onDataLoaded(violations);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                callback.onError(error.getMessage());
            }
        });
    }
}
