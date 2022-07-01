package com.hufei.cfg.replacebean;

import java.lang.annotation.*;

/**
 * <p> 自定义spring替换bean注解 </p>
 *
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
