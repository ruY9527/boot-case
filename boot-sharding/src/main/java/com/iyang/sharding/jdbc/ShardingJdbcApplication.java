package com.iyang.sharding.jdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/****
 * author: BaoYang
 * date: 2023/6/9
 * desc:
 ***/



@SpringBootApplication
@MapperScan("com.iyang.sharding.jdbc")
public class ShardingJdbcApplication {

    public static void main(String[] args) {

        SpringApplication.run(ShardingJdbcApplication.class, args);
    }

}
