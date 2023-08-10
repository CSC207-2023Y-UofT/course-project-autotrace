package com.course_project_autotrace;

import static org.mockito.Mockito.*;

import android.content.Intent;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.*;

import com.course_project_autotrace.Hompage.HomeScreen;
import com.course_project_autotrace.RegisterNewVehicle.RegisterNewVehicle;
import com.course_project_autotrace.RegisterNewVehicle.RegisterNewVehiclePresenter;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.R)

public class RegisterNewVehicleTest {

    private RegisterNewVehicle activity;

    @Before
    public void setUp() {
        ActivityController<RegisterNewVehicle> activityController = Robolectric.buildActivity(RegisterNewVehicle.class);
        activity = activityController.get();
        activityController.create();
    }

    @Test
    public void clickingRegisterButton_shouldShowToast_onSuccess() {
        RegisterNewVehiclePresenter mockPresenter = mock(RegisterNewVehiclePresenter.class);
        doAnswer(invocation -> {
            activity.onCarAddSuccess();
            return null;
        }).when(mockPresenter).registerNewVehicle(anyString());

        activity.setPresenter(mockPresenter);

        Button registerButton = activity.findViewById(R.id.RegisterBtn);
        EditText licensePlate = activity.findViewById(R.id.LicensePlate);

        licensePlate.setText("ABC123");
        registerButton.performClick();

        assertEquals("Car added successfully", ShadowToast.getTextOfLatestToast());
        Intent startedIntent = Shadows.shadowOf(activity).getNextStartedActivity();
        assertEquals(HomeScreen.class.getName(), startedIntent.getComponent().getClassName());
    }

    // Similarly, you can write tests for failure scenarios and other functionalities
}
