package com.iress.model;

public class CommandType {
    public static final String MOVE = "MOVE";
    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";
    public static final String REPORT = "REPORT";
    public static final String PLACE = "^(PLACE)\\s+\\d+,\\d+,(NORTH|WEST|EAST|SOUTH)$";

}
