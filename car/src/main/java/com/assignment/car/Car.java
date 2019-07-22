package com.assignment.car;

/**
 * Base class of com.assignment.car.Car
 */
public interface Car {

    /*  *//**
     * The car accept the command and move to the specified location.
     * The format of the instruction is {action,step}:action in['forward','turns' ],step is the step of action
     * @param command
     *//*
   void move(String command);*/

    /**
     * The car accept the command and move to the specified location.
     * @param action turns clockwise or moves forward
     * @param step the step of action
     */
    void move(ActionEnum action,int step);

    int getPositionX();

    int getPositionY();

    String getOrientation();
}
