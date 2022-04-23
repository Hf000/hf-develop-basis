package com.hufei.design.patterns.creational.prototype;

/**
 * 原型接口
 */
public interface IPrototype {
    /**
     * 这个复制方法必须提供
     * @return 返回对象
     */
    IPrototype copy();
}