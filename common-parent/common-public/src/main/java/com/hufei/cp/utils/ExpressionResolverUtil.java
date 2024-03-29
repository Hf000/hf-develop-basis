package com.hufei.cp.utils;

import com.hufei.cp.config.ExpressionResolverConfiguration;
import com.hufei.cp.constants.CpConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.BeanExpressionContext;
import org.springframework.beans.factory.config.BeanExpressionResolver;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.expression.StandardBeanExpressionResolver;

/**
 * <p> EL表达式解析工具类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/12 9:48
 */
public class ExpressionResolverUtil {

    /**
     * 表达式语言处理器
     */
    protected static final BeanExpressionResolver RESOLVER = new StandardBeanExpressionResolver();

    /**
     * 解析EL表达式获取配置文件中配置的值
     * @param configurableBeanFactory  注入了属性的容器对象
     * @param param 一个固定值或一个${}表达式
     * @return 值
     */
    protected static Object expressionAnalysis(ConfigurableBeanFactory configurableBeanFactory, String param) {
        if (null == configurableBeanFactory || StringUtils.isBlank(param)) {
            return null;
        }
        String resolveEmbeddedValue = configurableBeanFactory.resolveEmbeddedValue(param);
        if (null == resolveEmbeddedValue) {
            return null;
        }
        if (!(StringUtils.startsWith(resolveEmbeddedValue, CpConstant.DOLLAR_SIGN_BEFORE_BIG_PARANTHESES) && StringUtils.endsWith(resolveEmbeddedValue, CpConstant.AFTER_BIG_PARANTHESES))) {
            return resolveEmbeddedValue;
        }
        return RESOLVER.evaluate(resolveEmbeddedValue, new BeanExpressionContext(configurableBeanFactory, null));
    }

    /**
     * 已配置属性容器对象
     * @param param 表达式
     * @return 值
     */
    public static Object expressionAnalysis(String param) {
        // 使用ExpressionResolverUtil解析表达式, 需要一个配置类辅助(辅助类需要加载到spring环境中, 加上@Configuration()), 并在配置类上添加@PropertySource("classpath:application.properties"), 其值为配置文件的相对路径
        return expressionAnalysis(new AnnotationConfigApplicationContext(ExpressionResolverConfiguration.class).getBeanFactory(), param);
    }

}
