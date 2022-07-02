package com.hufei.cfg.event;

import org.springframework.aop.support.AopUtils;
import org.springframework.core.ResolvableType;

/**
 * <p> 事件监听适配器 </p>
 * 如果没有默认实现可以直接实现EventListener接口
 * 自定义事件分发器实现 - 6
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/12 15:47
 */
public class EventListenerAdapter extends EventListenerAbstract<EventBase> {

    private final EventListener<EventBase> eventListener;

    private final ResolvableType declaredEventType;

    public EventListenerAdapter(EventListener<EventBase> eventListener) {
        this.eventListener = eventListener;
        this.declaredEventType = resolveDeclaredEventType(this.eventListener);
    }

    /**
     * 解析声明的事件类型
     * @param eventListener 事件监听
     * @return 解析结果
     */
    private static ResolvableType resolveDeclaredEventType(EventListener<? extends EventBase> eventListener) {
        ResolvableType declaredEventType = resolveDeclaredEventType(eventListener.getClass());
        if (null == declaredEventType) {
            Class<?> targetClass = AopUtils.getTargetClass(eventListener);
            if (targetClass != eventListener.getClass()) {
                declaredEventType = resolveDeclaredEventType(targetClass);
            }
        }
        return declaredEventType;
    }

    /**
     * 解析声明的事件类型
     * @param eventListenerType 时间监听类型
     * @return 解析结果
     */
    private static ResolvableType resolveDeclaredEventType(Class<?> eventListenerType) {
        ResolvableType resolvableType = ResolvableType.forClass(eventListenerType).as(EventListener.class);
        if (!resolvableType.hasGenerics()) {
            return null;
        }
        return resolvableType.getGeneric();
    }

    @Override
    public void onEvent(EventBase event) {
        this.eventListener.onEvent(event);
    }

    @Override
    public boolean supportEventType(ResolvableType eventType) {
        if (this.eventListener instanceof EventListenerAbstract) {
            return ((EventListenerAbstract<EventBase>) this.eventListener).supportEventType(eventType);
        }
        return null != this.declaredEventType && this.declaredEventType.isAssignableFrom(eventType);
    }
}
