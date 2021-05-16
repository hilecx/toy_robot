package com.iress.service.impl;

import com.iress.enums.Direction;
import com.iress.model.Robot;
import com.iress.service.Impl.RobotCommandDispatcherImpl;
import com.iress.service.Impl.RobotControllerImpl;
import com.iress.testutils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;

public class RobotCommandDispatcherTest {

    RobotCommandDispatcherImpl dispatcher;
    RobotControllerImpl controller;

    @BeforeEach
    void init() {
        controller = mock(RobotControllerImpl.class);
        dispatcher = new RobotCommandDispatcherImpl();
    }


    @Test
    public void testDispatcher() {
        Robot robot = Utils.createRobot();
        dispatcher.dispatch(robot, controller, "PLACE 0,0,NORTH");
        Mockito.verify(controller, Mockito.times(1))
                .place(anyObject(), anyInt(), anyInt(), any(Direction.class));

        dispatcher.dispatch(robot, controller, "PLACE  0,0,NORTH");
        Mockito.verify(controller, Mockito.times(2))
                .place(anyObject(), anyInt(), anyInt(), any(Direction.class));

        dispatcher.dispatch(robot, controller, "LEFT");
        Mockito.verify(controller, Mockito.times(1))
                .turnLeft(anyObject());

        dispatcher.dispatch(robot, controller, "RIGHT");
        Mockito.verify(controller, Mockito.times(1))
                .turnRight(anyObject());

        dispatcher.dispatch(robot, controller, "MOVE");
        Mockito.verify(controller, Mockito.times(1))
                .move(anyObject());

        dispatcher.dispatch(robot, controller, "REPORT");
        Mockito.verify(controller, Mockito.times(1))
                .doReport(anyObject());

    }

    @Test
    public void testDispatcherWrongCommand() {

        Robot robot = Utils.createRobot();
        dispatcher.dispatch(robot, controller, "WRONG");
        Mockito.verify(controller, Mockito.times(0))
                .place(anyObject(), anyInt(), anyInt(), any(Direction.class));
        Mockito.verify(controller, Mockito.times(0))
                .turnLeft(anyObject());
        Mockito.verify(controller, Mockito.times(0))
                .turnRight(anyObject());
        Mockito.verify(controller, Mockito.times(0))
                .move(anyObject());
        Mockito.verify(controller, Mockito.times(0))
                .doReport(anyObject());

        dispatcher.dispatch(robot, controller, "PLACE 0,0,0,NORTH");
        Mockito.verify(controller, Mockito.times(0))
                .place(anyObject(), anyInt(), anyInt(), any(Direction.class));
        Mockito.verify(controller, Mockito.times(0))
                .turnLeft(anyObject());
        Mockito.verify(controller, Mockito.times(0))
                .turnRight(anyObject());
        Mockito.verify(controller, Mockito.times(0))
                .move(anyObject());
        Mockito.verify(controller, Mockito.times(0))
                .doReport(anyObject());
    }

}
