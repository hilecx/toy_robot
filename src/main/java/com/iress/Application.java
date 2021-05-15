package com.iress;

import com.iress.model.Robot;
import com.iress.service.CommandDispatcher;
import com.iress.service.Controller;
import com.iress.service.Impl.RobotCommandDispatcherImpl;
import com.iress.service.Impl.RobotControllerImpl;

public class Application {
    private Controller robotController;
    private CommandDispatcher dispatcher;
    private Robot robot;

    public void init(){
        robotController = new RobotControllerImpl();
        dispatcher = new RobotCommandDispatcherImpl(robotController);
        robot = new Robot();
    }

    public void execute(String command){
        dispatcher.dispatch(robot, command);

    }
}
