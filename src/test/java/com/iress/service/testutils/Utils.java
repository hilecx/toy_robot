package com.iress.service.testutils;

import com.iress.enums.Direction;
import com.iress.model.Robot;

public class Utils {

    public static Robot createRobot() {
        Robot robot = new Robot();
        robot.setX(1);
        robot.setY(1);
        robot.setDirection(Direction.EAST);
        robot.setPlaced(true);
        return robot;
    }

    public static Robot createRobotNotPlaced() {
        return new Robot();
    }
}
