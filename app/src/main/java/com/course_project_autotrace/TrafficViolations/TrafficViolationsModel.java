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

public class TrafficViolationsModel {

    public interface OnDataLoaded {
        void onDataLoaded(DataSnapshot violations);
        void onError(String error);
    }

    private final DatabaseReference referenceToViolations;

    public TrafficViolationsModel() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String userID = user.getUid();

        referenceToViolations = FirebaseDatabase.getInstance().getReference().child("TrafficViolations");
    }

    public void fetchViolationsData(String driverLicense, OnDataLoaded callback) {
        referenceToViolations.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot violations = null;
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
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
