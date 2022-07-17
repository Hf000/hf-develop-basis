package com.hufei.application.jdk8.optional;

public class MyException extends Throwable {

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "exception message";
    }
}
