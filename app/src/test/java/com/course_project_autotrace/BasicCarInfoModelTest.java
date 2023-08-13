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
import com.course_project_autotrace.Entities.CarEntity;
import com.course_project_autotrace.BasicCarInfo.FetchCarInfoUseCase;

public class BasicCarInfoModelTest {

    @Mock
    BasicCarInfoView view;
    @Mock
    FetchCarInfoUseCase fetchCarInfoUseCase;
    @Mock
    Intent intent;

    BasicCarInfoPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new BasicCarInfoPresenter(view, fetchCarInfoUseCase);
    }

    @Test
    public void testLoadCarInfo() {
        CarEntity.Car car = new CarEntity.Car("Tesla", "2020", "Electric Car", "Full Insurance");
        when(fetchCarInfoUseCase.fromIntent(intent)).thenReturn(car);

        presenter.loadCarInfo(intent);

        verify(view).displayCarDetails(car);
    }

    @Test
    public void testHandleBackClicked() {
        presenter.handleBackClicked();

        verify(view).navigateToLoginScreen();
    }
}
