package com.hufei.cfg.custom.expression;

import java.lang.annotation.*;

/**
 * <p> 自定义注解: 获取方法上的参数, 并将参数的值赋值给注解的表达式 </p>
 * 注解CustomParamsAnnotation实现 - 1
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/12 15:29
 */
@Inherited
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomParamsAnnotation {

    String[] value() default "";

}
