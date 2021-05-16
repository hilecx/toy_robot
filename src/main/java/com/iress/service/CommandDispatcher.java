package com.iress.service;

public interface CommandDispatcher<T, U extends Controller> {

    void dispatch(T t, U u, String command);

}
