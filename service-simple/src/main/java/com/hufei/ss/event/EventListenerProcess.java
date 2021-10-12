package com.hufei.ss.event;

import com.hufei.cfg.annotation.EventListenerAnnotation;
import com.hufei.cfg.event.EventListenerAbstract;
import com.hufei.ss.beans.pojo.EventEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> 监听器实现 </p>
 * 如果不需要默认业务逻辑, 可以直接实现EventListener接口
 * 注解@EventListenerAnnotation修饰的类已交给spring管理可以直接进行bean的注入
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/12 17:17
 */
@Slf4j
@EventListenerAnnotation
public class EventListenerProcess extends EventListenerAbstract<EventEntity> {
    @Override
    public void onEvent(EventEntity event) {
        log.info("监听测试==>{}", event.toString());
    }
}
