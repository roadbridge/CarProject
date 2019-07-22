package com.assignment.car;

/**
 * Enum of the car action
 */
public enum ActionEnum {
    MOVES_FORWARD("moves forward"),
    TURNS_CLOCKWISE("turns clockwise");

    private String name;

    ActionEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
