package com.iyang.bootmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 扫描MyBatis注解的配置
@MapperScan("com.iyang.bootmybatisplus.mapper")
public class BootMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootMybatisPlusApplication.class, args);
    }

}
