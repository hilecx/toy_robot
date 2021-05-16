package com.iress.service;

import com.iress.enums.Direction;

public interface Controller<T> {

    public void doReport(T t);
    public void move(T t);
    public void turnLeft(T t);
    public void turnRight(T t);
    public void place(T t, Integer x, Integer y, Direction direction);
}
