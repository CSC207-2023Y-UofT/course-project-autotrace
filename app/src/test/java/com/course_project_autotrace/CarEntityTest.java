package com.course_project_autotrace;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.course_project_autotrace.Entities.CarEntity;

public class CarEntityTest {

    private CarEntity.Car car;

    @Before
    public void setUp() {
        car = new CarEntity.Car("Tesla", "2020", "Electric Car", "Full Insurance");
    }

    @Test
    public void testGetModel() {
        assertEquals("2020", car.getModel());
    }

    @Test
    public void testGetName() {
        assertEquals("Tesla", car.getName());
    }

    @Test
    public void testGetInfo() {
        assertEquals("Electric Car", car.getInfo());
    }

    @Test
    public void testGetInsurance() {
        assertEquals("Full Insurance", car.getInsurance());
    }
}
