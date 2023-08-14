package com.course_project_autotrace.CarInformation;
import java.util.Objects;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import androidx.annotation.NonNull;

public class CarInfoModel {
    interface OnDataFetched {
        void onDataReceived(String name, String model, String owner, String insuranceInfo);
        void onError();
    }
    public void fetchCarInfo(OnDataFetched callback) {
        String userID = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
        DatabaseReference referenceToUsers = FirebaseDatabase.getInstance().getReference().child("UserAccountEntity").child("Cars").child(userID);

        referenceToUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Name = snapshot.child("Name").getValue(String.class);
                String model = snapshot.child("Model").getValue(String.class);
                String Owner = snapshot.child("Owner").getValue(String.class);
                String insuranceInfo = snapshot.child("Insurance").getValue(String.class);
                callback.onDataReceived(Name, model, Owner, insuranceInfo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                callback.onError();
            }
        });
    }
}
