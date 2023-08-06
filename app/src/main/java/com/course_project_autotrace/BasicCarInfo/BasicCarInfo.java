package com.course_project_autotrace.BasicCarInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.course_project_autotrace.Login.LoginScreen;
import com.course_project_autotrace.R;

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