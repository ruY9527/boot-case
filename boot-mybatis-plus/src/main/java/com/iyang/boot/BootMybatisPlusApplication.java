package com.iyang.boot;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.*;

@Slf4j
@SpringBootApplication
// 扫描MyBatis注解的配置
@MapperScan("com.iyang.boot.mapper")
public class BootMybatisPlusApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BootMybatisPlusApplication.class, args);

        DataSource bean = context.getBean(DataSource.class);

        log.info("the bean name is ---> {} " , bean.getClass());

/*        HikariDataSource hikariDataSource = DataSourceBuilder.create()
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://172.21.129.214:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai")
                .username("root")
                .password("YdMysqlxxl")
                .type(HikariDataSource.class)
                .build();*/




        Object yangDataSource = ApplicationContextUtil.registerBean("yangDataSource");

        yangDataSource = (HikariDataSource) yangDataSource;
        try {
            Connection connection = ((HikariDataSource) yangDataSource).getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("show tables");
            while (resultSet.next()){
                String tableName = resultSet.getString(1);
                System.out.println("the tableName is ---> " + tableName);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        // ApplicationContextUtil.getBeanByName("yangDataSource");

    }

}
