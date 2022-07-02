package com.hufei.cfg.custom.replacebean;

import java.lang.annotation.*;

/**
 * <p> 自定义spring替换bean注解 </p>
 * 自定义spring容器中替换bean注解CustomBeanReplace实现 - 1
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/9 15:29
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomBeanReplace {

    String value() default "";

}
