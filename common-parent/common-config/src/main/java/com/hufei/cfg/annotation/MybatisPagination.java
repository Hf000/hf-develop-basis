package com.hufei.cfg.annotation;

import java.lang.annotation.*;

/**
 * <p> 自定义mybatis分页注解 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/11/2 10:56
 */
@Inherited
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MybatisPagination {

    /**第几页的请求参数, 通过获取指定参数名称参数的值**/
    String pageNo() default "pageNo";

    /**分页大小的请求参数**/
    String pageSize() default "pageSize";

}
