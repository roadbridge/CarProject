package com.assignment.car;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Junit for DriverLessCar
 */
public class DriverLessCarTest {
    private Car car;

    @Before
    public void setUp() throws Exception {
        //this.car = new DriverLessCar(1, 1, OrientationEnum.North);
        this.car = new DriverLessCar(1, 1, OrientationEnum.East);
        //this.car = new DriverLessCar(1, 1, OrientationEnum.West);
    }

    @After
    public void tearDown() throws Exception {
        this.car = null;
    }

    @Test
    public void move() {
        //this.car.move(ActionEnum.TURNS_CLOCKWISE, 1);

        this.car.move(ActionEnum.MOVES_FORWARD, 1);
    }

    @Test
    public void getPositionX() {
        this.car.move(ActionEnum.MOVES_FORWARD, 2);
        Assert.assertEquals(this.car.getPositionX(),3);
    }

    @Test
    public void getPositionY() {
        this.car.move(ActionEnum.TURNS_CLOCKWISE, 3);
        this.car.move(ActionEnum.MOVES_FORWARD, 1);
        Assert.assertEquals(this.car.getPositionY(),2);
    }

    @Test
    public void getOrientation() {
        this.car.move(ActionEnum.TURNS_CLOCKWISE, 1);
        Assert.assertEquals(this.car.getOrientation(),OrientationEnum.South.getName());
    }
}
