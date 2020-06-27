package com.iyang.admin.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/27 0:58
 * @Version 1.0
 * @qq: 1411091515
 */

@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class AdminServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(AdminServerApplication.class,args);

    }

}
