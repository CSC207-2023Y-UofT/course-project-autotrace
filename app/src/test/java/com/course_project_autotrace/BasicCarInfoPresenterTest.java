package com.course_project_autotrace;

import android.content.Intent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.course_project_autotrace.BasicCarInfo.BasicCarInfoPresenter;
import com.course_project_autotrace.BasicCarInfo.BasicCarInfoView;
import com.course_project_autotrace.BasicCarInfo.CarEntity;
import com.course_project_autotrace.BasicCarInfo.FetchCarInfoUseCase;

public class BasicCarInfoPresenterTest {

    private BasicCarInfoPresenter presenter;

    @Mock
    private BasicCarInfoView mockView;

    @Mock
    private FetchCarInfoUseCase mockFetchInfoUseCase;

    @Mock
    private Intent mockIntent;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initialize the mock objects
        presenter = new BasicCarInfoPresenter(mockView, mockFetchInfoUseCase);
    }

    @Test
    public void loadCarInfo_displaysCarDetails() {
        // Given a car data in the intent
        CarEntity.Car testCar = new CarEntity.Car("Tesla", "2020", "Electric Car", "Full Insurance");
        when(mockFetchInfoUseCase.fromIntent(mockIntent)).thenReturn(testCar);

        // When loadCarInfo is called
        presenter.loadCarInfo(mockIntent);

        // Then the view should display the car details
        verify(mockView).displayCarDetails(testCar);
    }

    @Test
    public void handleBackClicked_navigatesToLoginScreen() {
        // When handleBackClicked is called
        presenter.handleBackClicked();

        // Then the view should navigate to the LoginScreen
        verify(mockView).navigateToLoginScreen();
    }
}

