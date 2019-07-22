package com.assignment.car;

import java.util.regex.Pattern;

/**
 * Driverless car
 */
public class DriverLessCar implements Car{
    /**
     * positionX of the car
     */
    private int positionX;
    /**
     * positionY of the car
     */
    private int positionY;
    /**
     * orientation of the car facing to
     */
    private String orientation;

    public DriverLessCar(int positionX, int positionY, OrientationEnum orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation.getName();
    }

    /*public void move(String command) {
        if (command == null || command.trim().length() == 0){
            throw  new RuntimeException("Parameter error: Parameter is empty");
        }
        String pattern = "^(forward|turns),\\d*$";
        if (Pattern.matches(pattern, command) == false){
            throw  new RuntimeException("Incorrect parameter format: {'forward'|'turns',step}");
        }

        String[] commandArray = command.split(",");
        String action = commandArray[0];
        int step = Integer.parseInt(commandArray[1]);

        this.move(action, step);
    }*/

    public void move(ActionEnum action, int step){
        int oldPositionX = this.positionX;
        int oldPositionY = this.positionY;
        String oldOrientation = this.orientation;

        if(ActionEnum.TURNS_CLOCKWISE.equals(action)){
            this.orientation = OrientationEnum.getNext(this.orientation, step);
        }else {
            switch (OrientationEnum.valueOf(this.orientation)){
                case North:
                    this.positionY += step;
                    break;
                case East:
                    this.positionX += step;
                    break;
                case South:
                    this.positionY -= step;
                    break;
                default:
                    this.positionX -= step;
            }
            if (Park.outside(this.positionX, this.positionY)){
                throw  new RuntimeException("The car moves outside the car park boundaries");
            }
        }

        formatOutput(action, step, oldPositionX, oldPositionY, oldOrientation);
    }

    /**
     * format the car information and output
     * @param action
     * @param step
     */
    private void formatOutput(ActionEnum action, int step,int oldPositionX,int oldPositionY,String oldOrientation){
        StringBuilder output = new StringBuilder("- Given the Car is in ");

        output.append("position X = ");
        output.append(oldPositionX);

        output.append(" position Y = ");
        output.append(oldPositionY);

        output.append(" and facing ");
        output.append(oldOrientation);

        output.append(", when the Car ");
        output.append(action.getName());
        output.append(" ");
        output.append(step);
        output.append(", then the Car is still ");

        if (action.equals(ActionEnum.TURNS_CLOCKWISE)){
            output.append("in the same position but is now facing ");
            output.append(this.orientation);
        }else {
            output.append("facing ");
            output.append(this.orientation);
            output.append(" but is now in position X = ");
            output.append(this.positionX);
            output.append(" and Y = ");
            output.append(this.positionY);
        }

        System.out.println(output.toString());
    }

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public String getOrientation() {
        return this.orientation;
    }
}
