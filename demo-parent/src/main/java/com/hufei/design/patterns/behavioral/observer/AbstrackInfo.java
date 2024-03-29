package com.hufei.design.patterns.behavioral.observer;

/**
* <p> 观察者模式 </p>
* @author hufei
* @date 2022/7/13 21:24
*/
public abstract class AbstrackInfo {

    //被监听的对象
    private Clock clock;

    abstract  void message();
}
