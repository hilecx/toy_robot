package com.iress.service.Impl;

import com.iress.enums.Direction;
import com.iress.model.Robot;
import com.iress.model.Table;
import com.iress.service.Controller;

public class RobotControllerImpl implements Controller<Robot> {

    @Override
    public void doReport(Robot robot) {
        if(!robot.isPlaced()){
            return;
        }
        System.out.println(String.format("Output: %d,%d,%s", robot.getX(), robot.getY(), robot.getDirection().getDescription()));
    }

    @Override
    public void move(Robot robot) {
        if(!robot.isPlaced()){
            return;
        }
        int[] nextPosition = nextPosition(robot.getX(),robot.getY(),robot.getDirection());
        if(isInTable(nextPosition[0], nextPosition[1])){
            robot.setX(nextPosition[0]);
            robot.setY(nextPosition[1]);
        }
    }

    @Override
    public void turnLeft(Robot robot) {
        if(!robot.isPlaced()){
            return;
        }
        robot.setDirection(robot.getDirection().trunLeft());
    }

    @Override
    public void turnRight(Robot robot) {
        if(!robot.isPlaced()){
            return;
        }
        robot.setDirection(robot.getDirection().trunRight());
    }

    @Override
    public void place(Robot robot, Integer x, Integer y, Direction direction) {
        if(!isInTable(x,y)){
            return;
        }
        robot.setX(x);
        robot.setY(y);
        robot.setDirection(direction);
        robot.setPlaced(true);
    }

    public int[] nextPosition(Integer x, Integer y, Direction direction) {
        switch (direction) {
            case NORTH:
                y++;
                break;
            case EAST:
                x++;
                break;
            case SOUTH:
                y--;
                break;
            case WEST:
                x--;
                break;
            default:
        }
        return new int[]{x, y};
    }

    public boolean isInTable(Integer x, Integer y) {
        return x >= Table.MIN_POSITION && x <= Table.MAX_POSITION && y >= Table.MIN_POSITION && y <= Table.MAX_POSITION;
    }
}
