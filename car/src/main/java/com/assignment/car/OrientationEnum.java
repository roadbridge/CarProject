package com.assignment.car;

/**
 * Enum of the car orientation
 */
public enum OrientationEnum {
    North("North", 0),
    East("East", 1),
    South("South", 2),
    West("West", 3);

    private String name;
    private int index;

    OrientationEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public static String getNext(String current,int step){
        OrientationEnum[] array = OrientationEnum.values();

        int index = 0;
        for(OrientationEnum orientation :  OrientationEnum.values()){
            if (orientation.name.equals(current)){
                break;
            }
            index++;
        }

        index = (index + step ) % array.length;
        return array[index].name;
    }


}
