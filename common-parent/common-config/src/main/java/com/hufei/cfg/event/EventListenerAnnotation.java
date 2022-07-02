package com.hufei.cfg.event;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * <p> 事件监听器注解 </p>
 * 自定义事件分发器实现 - 1
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/12 15:56
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface EventListenerAnnotation {
}
