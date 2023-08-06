package com.course_project_autotrace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class BasicCarInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_car_info);
        Intent intent = getIntent();

        String carName = intent.getStringExtra("carName");
        String model = intent.getStringExtra("model");
        String info = intent.getStringExtra("info");
        String insurance = intent.getStringExtra("insurance");

        TextView carNameTextView = findViewById(R.id.CarName);
        TextView modelYearTextView = findViewById(R.id.ModelYear);
        TextView infoBoxTextView = findViewById(R.id.InfoBox);

        carNameTextView.setText(carName);
        modelYearTextView.setText(model);
        String formattedInfo = String.format("%s : %s", insurance, info);
        infoBoxTextView.setText(formattedInfo);



        ImageButton backBtn = findViewById(R.id.BackBtn);
        backBtn.setOnClickListener(v -> {
            Intent intent2 = new Intent(BasicCarInfo.this, LoginScreen.class);
            startActivity(intent2);
        });




    }
}