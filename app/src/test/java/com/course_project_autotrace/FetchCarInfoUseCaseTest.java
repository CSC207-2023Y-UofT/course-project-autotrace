package com.course_project_autotrace;

import android.content.Intent;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.course_project_autotrace.BasicCarInfo.CarEntity;
import com.course_project_autotrace.BasicCarInfo.FetchCarInfoUseCase;

public class FetchCarInfoUseCaseTest {

    @Mock
    Intent intent;
    FetchCarInfoUseCase fetchCarInfoUseCase;

    @Before
    public void setUp() {
        fetchCarInfoUseCase = new FetchCarInfoUseCase();
        intent = mock(Intent.class);
    }

    @Test
    public void testFromIntent() {
        when(intent.getStringExtra("carName")).thenReturn("Tesla");
        when(intent.getStringExtra("model")).thenReturn("2020");
        when(intent.getStringExtra("info")).thenReturn("Electric Car");
        when(intent.getStringExtra("insurance")).thenReturn("Full Insurance");

        CarEntity.Car car = fetchCarInfoUseCase.fromIntent(intent);

        assertEquals("Tesla", car.getName());
        assertEquals("2020", car.getModel());
        assertEquals("Electric Car", car.getInfo());
        assertEquals("Full Insurance", car.getInsurance());
    }
}

