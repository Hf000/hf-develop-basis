package com.hufei.design.patterns.creational.factory.abstractf;

/**
 * <p> 抽象工厂接口 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2022/4/23 15:53
 */
public interface IAbstractFactory {

    IKeyboard createKeyboard();

    IMonitor createMonitor();

}
