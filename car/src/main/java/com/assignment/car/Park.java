package com.assignment.car;

/**
 * Constant of Park
 */
public class Park{
    /**
     * x length of the car park
     */
    public static int positionXMax = 4;
    /**
     * y length of the car park
     */
    public static int positionYMax = 4;


    /**
     *  if the car moves outside the car park boundaries
     * @param positionX
     * @param positionY
     * @return
     */
    public static boolean outside(int positionX,int positionY){
        if (positionX <= 0 || positionX > positionXMax ||positionY <= 0 || positionY > positionYMax){
            return true;
        }

        return false;
    }

}
