package com.hufei.mts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p> 启动类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/2/21 21:13
 */
//开启通用mapper的包扫描
//@MapperScan("com.hufei.mts.mapper")
//开启mybatis的包扫描，注意：开启通用mapper的包扫描后要将此注解注释掉
@MapperScan("com.hufei.mts.mapper")
@SpringBootApplication
public class MybatisTkApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisTkApplication.class, args);
    }

}
