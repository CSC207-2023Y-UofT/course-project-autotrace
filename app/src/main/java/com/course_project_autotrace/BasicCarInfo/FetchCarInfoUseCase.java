package com.course_project_autotrace.BasicCarInfo;

import android.content.Intent;

/**
 * Use case class for fetching car information.
 */
public class FetchCarInfoUseCase {

    /**
     * Extracts car details from a given intent and returns a Car object.
     *
     * This method is intended to fetch data from the intent that is passed from the LoginScreen.
     *
     * @param intent The intent containing car details.
     * @return A new Car object populated with the data extracted from the intent.
     */
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
