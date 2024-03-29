package com.hufei.design.patterns.creational.factory.abstractf;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>  </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2022/4/23 15:56
 */
@Slf4j
public class LenovoMonitorImpl implements IMonitor {
    @Override
    public void output() {
        log.info("Lenovo抽象工厂显示器");
    }
}
