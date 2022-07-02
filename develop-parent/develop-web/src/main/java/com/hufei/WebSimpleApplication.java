package com.hufei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p> 启动类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/9 10:11
 */
@SpringBootApplication
@MapperScan("com.hufei.*.dao")  // mybatis的mapper扫描
public class WebSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSimpleApplication.class, args);
    }

}
