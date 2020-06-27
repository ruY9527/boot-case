package com.iyang.boot.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/27 23:11
 * @Version 1.0
 * @qq: 1411091515
 */

@EnableDiscoveryClient
@SpringBootApplication
public class BootAdminClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(BootAdminClientApplication.class,args);

    }

}
