package com.hufei.cfg.event;

/**
 * <p> 事件监听实现方式一: 事件监听器接口 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/12 15:35
 */
public interface EventListener<E extends EventBase> {

    /**
     * 监听到事件的方法
     * @param event 监听到的事件
     */
    void onEvent(E event);

}
