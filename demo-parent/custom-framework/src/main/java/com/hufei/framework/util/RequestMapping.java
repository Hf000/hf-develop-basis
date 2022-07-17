package com.hufei.framework.util;

import java.lang.annotation.*;

/**
 * <p>  </p>
 * @author hufei
 * @date 2022/7/17 19:27
*/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {

    //定义一个注解的属性，属性名字叫value  default  默认值
    String value() default "";
}
