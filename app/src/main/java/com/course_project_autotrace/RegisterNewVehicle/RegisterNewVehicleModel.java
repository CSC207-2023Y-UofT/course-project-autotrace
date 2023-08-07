package com.course_project_autotrace.RegisterNewVehicle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.annotation.NonNull;
import java.util.Objects;

public class RegisterNewVehicleModel {
    private final DatabaseReference referenceToUsers = FirebaseDatabase.getInstance().getReference().child("UserAccount");
    private final DatabaseReference referenceToCars = FirebaseDatabase.getInstance().getReference().child("Cars");

    public void addCarForUserInDB(String userID, DataSnapshot carInfo, OnDatabaseUpdateListener listener){
        referenceToUsers.child(userID).child("Cars").child(Objects.requireNonNull(carInfo.getKey())).setValue(carInfo.getValue())
                .addOnSuccessListener(aVoid -> listener.onSuccess())
                .addOnFailureListener(e -> listener.onFailure());
    }

    // check if the car exists in the database

    public void checkIfCarExists(String enteredLicensePlateNum, OnCarDatabaseCheckListener listener2) {
        referenceToCars.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // traverse through all the cars and check if it matches the one with the user logged in
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (Objects.equals(snapshot.getKey(), enteredLicensePlateNum)){
                        listener2.OnCarExistInDB(snapshot);
                        return;
                    }
                    listener2.onCarNotExistInDB();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void addCarToUser(String userID, DataSnapshot dataSnapshot, OnDatabaseUpdateListener onDatabaseUpdateListener) {
    }

    // interface to listen if the car exists or not in the database
    public interface OnCarDatabaseCheckListener{
        void OnCarExistInDB(DataSnapshot dataSnapshot);
        void onCarNotExistInDB();
    }

    // interface to update the database on the user
    public interface OnDatabaseUpdateListener {
        void onSuccess();
        void onFailure();
    }
}
