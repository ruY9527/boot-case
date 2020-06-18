package com.iyang.txlcn.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-18
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

@SpringBootApplication
@EnableEurekaServer
public class TxLcnEurekaServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(TxLcnEurekaServerApplication.class,args);

    }

}
