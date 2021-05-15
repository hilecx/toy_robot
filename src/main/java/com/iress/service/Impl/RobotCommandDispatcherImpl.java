package com.iress.service.Impl;

import com.iress.enums.Direction;
import com.iress.model.CommandType;
import com.iress.model.Robot;
import com.iress.service.CommandDispatcher;
import com.iress.service.Controller;

public class RobotCommandDispatcherImpl implements CommandDispatcher<Robot> {
    Controller controller;

    public RobotCommandDispatcherImpl(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void dispatch(Robot robot, String command) {
        if (command.matches(CommandType.PLACE)) {
            PlaceCommand placeCommand = generatePlaceCommand(command);
            controller.place(robot, placeCommand.getX(),placeCommand.getY(),placeCommand.getDirection());
            return;
        }

        switch (command) {
            case CommandType.LEFT:
                controller.turnLeft(robot);
                break;
            case CommandType.RIGHT:
                controller.turnRight(robot);
                break;
            case CommandType.MOVE:
                controller.move(robot);
                break;
            case CommandType.REPORT:
                controller.doReport(robot);
                break;
            default:
        }
    }

    private PlaceCommand generatePlaceCommand(String command) {
        String[] args = command.replace("PLACE", "").split(",");
        if (args.length != 3) {
            throw new IllegalArgumentException("PLACE should have 3 args");
        }
        return new PlaceCommand(Integer.valueOf(args[0].trim()), Integer.valueOf(args[1].trim()), Direction.valueOf(args[2]));
    }
}

class PlaceCommand {
    private Integer x;
    private Integer y;
    private Direction direction;

    public PlaceCommand(Integer x, Integer y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }


}
