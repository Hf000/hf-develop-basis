package com.hufei.dw.config;

import com.hufei.dw.constants.ConstantNumber;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Constants;

import javax.annotation.PostConstruct;

/**
 * <p> 常量缓存, 将一类常量放到一起 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/14 15:14
 */
@Data
@Configuration
public class ConstantCacheConfig {

    private Constants constantNumber;

    @PostConstruct
    public void init() {
        if (null == constantNumber) {
            constantNumber = new Constants(ConstantNumber.class);
        }
    }

}
