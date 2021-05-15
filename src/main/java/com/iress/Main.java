package com.iress;

import com.iress.model.Robot;
import com.iress.service.CommandDispatcher;
import com.iress.service.Controller;
import com.iress.service.Impl.RobotCommandDispatcherImpl;
import com.iress.service.Impl.RobotControllerImpl;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Application application = new Application();
        application.init();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (command != null && !command.equals("")) {
//            System.out.println(command);
            application.execute(command);
            command = scanner.nextLine();
        }

        System.out.println("Exit");

    }

}
