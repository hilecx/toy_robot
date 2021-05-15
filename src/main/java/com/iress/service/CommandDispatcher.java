package com.iress.service;

public interface CommandDispatcher<T> {

    void dispatch(T t, String command);

}
