package com.iress.service.impl;

import com.iress.enums.Direction;
import com.iress.model.Robot;
import com.iress.service.Impl.RobotControllerImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.iress.service.testutils.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RobotControllerTest {

    RobotControllerImpl controller;

    @BeforeEach
    void init(){
        controller = new RobotControllerImpl();
    }



    @Test
    public void testDoReport() {
        Robot robot = Utils.createRobot();
        controller.doReport(robot);
        robot.setPlaced(false);
        controller.doReport(robot);
    }

    @Test
    public void testMove() {
        Robot robot = Utils.createRobotNotPlaced();
        controller.move(robot);
        assertEquals(null, robot.getX());
        assertEquals(null, robot.getY());
        assertEquals(null, robot.getDirection());
        assertEquals(false, robot.isPlaced());

        robot = Utils.createRobot();
        controller.move(robot);
        assertEquals(2, robot.getX());
        assertEquals(1, robot.getY());
        assertEquals(Direction.EAST, robot.getDirection());
        assertEquals(true, robot.isPlaced());


    }

    @Test
    public void testTurnLeft() {
        Robot robot = Utils.createRobot();
        controller.turnLeft(robot);
        assertEquals(Direction.NORTH, robot.getDirection());
        controller.turnLeft(robot);
        assertEquals(Direction.WEST, robot.getDirection());
        controller.turnLeft(robot);
        assertEquals(Direction.SOUTH, robot.getDirection());
        controller.turnLeft(robot);
        assertEquals(Direction.EAST, robot.getDirection());
        robot = Utils.createRobotNotPlaced();
        controller.turnLeft(robot);
        assertEquals(null, robot.getDirection());
        assertEquals(false, robot.isPlaced());
    }

    @Test
    public void testTurnRight() {
        Robot robot = Utils.createRobot();

        controller.turnRight(robot);
        assertEquals(Direction.SOUTH, robot.getDirection());

        controller.turnRight(robot);
        assertEquals(Direction.WEST, robot.getDirection());

        controller.turnRight(robot);
        assertEquals(Direction.NORTH, robot.getDirection());

        controller.turnRight(robot);
        assertEquals(Direction.EAST, robot.getDirection());

        robot = Utils.createRobotNotPlaced();
        controller.turnRight(robot);
        assertEquals(null, robot.getDirection());
        assertEquals(false, robot.isPlaced());
    }

    @Test
    public void testPlace() {
        Robot robot = Utils.createRobotNotPlaced();

        controller.place(robot, -1, 0, Direction.EAST);
        assertEquals(null, robot.getDirection());
        assertEquals(false, robot.isPlaced());

        controller.place(robot, 2, 3, Direction.WEST);
        assertEquals(2, robot.getX());
        assertEquals(3, robot.getY());
        assertEquals(Direction.WEST, robot.getDirection());
        assertEquals(true, robot.isPlaced());

        robot = Utils.createRobot();
        controller.place(robot, 2, 3, Direction.WEST);
        assertEquals(2, robot.getX());
        assertEquals(3, robot.getY());
        assertEquals(Direction.WEST, robot.getDirection());
        assertEquals(true, robot.isPlaced());

    }


    @Test
    public void testNextPosition() {
        int[] result;
        result = controller.nextPosition(1, 1, Direction.EAST);
        assertEquals(2, result[0]);
        assertEquals(1, result[1]);

        result = controller.nextPosition(4, 1, Direction.EAST);
        assertEquals(5, result[0]);
        assertEquals(1, result[1]);

        result = controller.nextPosition(4, 1, Direction.WEST);
        assertEquals(3, result[0]);
        assertEquals(1, result[1]);

        result = controller.nextPosition(1, 1, Direction.SOUTH);
        assertEquals(1, result[0]);
        assertEquals(0, result[1]);

        result = controller.nextPosition(1, 0, Direction.SOUTH);
        assertEquals(1, result[0]);
        assertEquals(-1, result[1]);

        result = controller.nextPosition(1, 1, Direction.NORTH);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
    }


    @Test
    public void testIsInTable() {
        assertTrue(controller.isInTable(1, 1));
        assertTrue(controller.isInTable(0, 0));
        assertTrue(controller.isInTable(4, 4));
        assertTrue(!controller.isInTable(4, 5));
        assertTrue(!controller.isInTable(4, -1));
        assertTrue(!controller.isInTable(-1, 3));
        assertTrue(!controller.isInTable(5, 1));
    }
}
