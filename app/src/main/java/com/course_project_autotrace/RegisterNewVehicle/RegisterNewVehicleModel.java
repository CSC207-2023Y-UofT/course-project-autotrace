package com.course_project_autotrace.RegisterNewVehicle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.annotation.NonNull;
import java.util.Objects;

/**
 * Model class responsible for interacting with the Firebase database to manage vehicle registration.
 */
public class RegisterNewVehicleModel {

    private final DatabaseReference referenceToUsers = FirebaseDatabase.getInstance().getReference().child("UserAccountEntity");
    private final DatabaseReference referenceToCars = FirebaseDatabase.getInstance().getReference().child("Cars");

    /**
     * Adds a car associated with a specific user ID to the database.
     *
     * @param userID The ID of the user.
     * @param carInfo Information about the car to be added.
     * @param listener Callback for database update operations.
     */
    public void addCarForUserInDB(String userID, DataSnapshot carInfo, OnDatabaseUpdateListener listener) {
        referenceToUsers.child(userID).child("Cars").child(Objects.requireNonNull(carInfo.getKey())).setValue(carInfo.getValue())
                .addOnSuccessListener(aVoid -> listener.onSuccess())
                .addOnFailureListener(e -> listener.onFailure());
    }

    /**
     * Checks if a specific car exists in the database.
     *
     * @param enteredLicensePlateNum License plate number of the car to be checked.
     * @param listener2 Callback to check the existence of the car in the database.
     */
    public void checkIfCarExists(String enteredLicensePlateNum, OnCarDatabaseCheckListener listener2) {
        referenceToCars.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (Objects.equals(snapshot.getKey(), enteredLicensePlateNum)) {
                        listener2.OnCarExistInDB(snapshot);
                        return;
                    }
                    listener2.onCarNotExistInDB();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle potential errors here.
            }
        });
    }

    // This method seems unused or incomplete. Please verify if this is intentional.
    public void addCarToUser(String userID, DataSnapshot dataSnapshot, OnDatabaseUpdateListener onDatabaseUpdateListener) {
    }

    /**
     * Interface to provide callbacks based on checking if a car exists or not in the database.
     */
    public interface OnCarDatabaseCheckListener {

        /**
         * Callback method for when the car exists in the database.
         *
         * @param dataSnapshot Snapshot of the data in the database.
         */
        void OnCarExistInDB(DataSnapshot dataSnapshot);

        /**
         * Callback method for when the car does not exist in the database.
         */
        void onCarNotExistInDB();
    }

    /**
     * Interface to provide callbacks after trying to update the database.
     */
    public interface OnDatabaseUpdateListener {

        /**
         * Callback method for a successful database update.
         */
        void onSuccess();

        /**
         * Callback method for a failed database update.
         */
        void onFailure();
    }
}
