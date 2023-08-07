package com.course_project_autotrace.BasicCarInfo;

import android.content.Intent;

public class FetchCarInfoUseCase {
    public CarEntity.Car fromIntent(Intent intent){
        // Fetch data from the intent sent from the LoginScreen
        return new CarEntity.Car(
                intent.getStringExtra("carName"),
                intent.getStringExtra("model"),
                intent.getStringExtra("info"),
                intent.getStringExtra("insurance")
        );
    }
}
