package com.hufei.cfg.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

/**
 * <p> 事件发布器实现类 </p>
 * 如果没有默认逻辑, 可以直接实现EventPublisher接口
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/12 17:05
 */
@Slf4j
@Component
@ConditionalOnBean(EventMulticaster.class)
public class EventPublisherImpl extends EventPublisherAbstract {

    private final EventMulticaster eventMulticaster;

    public EventPublisherImpl(EventMulticaster eventMulticaster) {
        this.eventMulticaster = eventMulticaster;
    }

    @Override
    public void publish(EventBase event) {
        log.info("EventPublisherImpl.publish event-key:[{}]", ((EventBase) event).getKey());
        // 进行事件分发
        eventMulticaster.multicastEvent((EventBase) event);
    }

}
