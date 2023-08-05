package com.course_project_autotrace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;


public class RegisterNewVehicle extends AppCompatActivity {
    private DatabaseReference referenceToUsers, referenceToCars;
    private EditText licensePlate;
    private String userID;
    private DataSnapshot car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_vehicle);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        userID = user.getUid();
        referenceToUsers = FirebaseDatabase.getInstance().getReference().child("UserAccount");
        referenceToCars = FirebaseDatabase.getInstance().getReference().child("Cars");

        Button registerVehicleBtn = findViewById(R.id.RegisterBtn);
        licensePlate = findViewById(R.id.LicensePlate);
        EditText lastName = findViewById(R.id.LastName);
        EditText DOB = findViewById(R.id.DOB);

        registerVehicleBtn.setOnClickListener(v -> {
            final String enteredLicensePlate = licensePlate.getText().toString();

            referenceToCars.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        if (Objects.equals(snapshot.getKey(), enteredLicensePlate)){
                            car = snapshot;
                        }
                    }

                    if (car != null) {
                        referenceToUsers.child(userID).child(Objects.requireNonNull(car.getKey())).setValue(car.getValue()).addOnSuccessListener(aVoid -> {
                            Toast.makeText(RegisterNewVehicle.this, "Car added successfully", Toast.LENGTH_LONG).show();
                            // Here you can also navigate to another activity if needed
                        }).addOnFailureListener(e -> Toast.makeText(RegisterNewVehicle.this, "Failed to add car", Toast.LENGTH_LONG).show());
                    }
                    else{
                        Toast.makeText(RegisterNewVehicle.this, "Car does not exist in the database", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            Intent intent = new Intent(RegisterNewVehicle.this, HomeScreen.class);  // Assuming your Home screen is HomeScreenActivity
            startActivity(intent);
            finish();
        });
    }
}
