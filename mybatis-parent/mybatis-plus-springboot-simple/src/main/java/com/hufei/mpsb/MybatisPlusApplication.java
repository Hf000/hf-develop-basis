package com.hufei.mpsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//扫描mapper包, 如果Mapper类加了@Mapper注解就不需要这个扫描注解了
// @MapperScan("com.hufei.mpsb.mapper")
@SpringBootApplication
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }

}