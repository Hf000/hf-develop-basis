package com.hufei.application.jdk8.defaultAndStatic;

public interface MyInterface {

    default void method(){
        System.out.println("myInterface default method");
    }
}
