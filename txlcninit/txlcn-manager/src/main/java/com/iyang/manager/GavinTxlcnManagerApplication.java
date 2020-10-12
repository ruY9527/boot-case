package com.iyang.manager;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
// 启动 tx-manager 事务管理器
@EnableTransactionManagerServer
public class GavinTxlcnManagerApplication {

    public static void main(String[] args) {

        SpringApplication.run(GavinTxlcnManagerApplication.class,args);

    }

}
