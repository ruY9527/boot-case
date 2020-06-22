package com.iyang.bootbasicio;

import jdk.management.resource.internal.inst.ServerSocketChannelImplRMHooks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;

@SpringBootApplication
public class BootBasicIoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootBasicIoApplication.class, args);

        // Channel
        //SelectionKey


    }

}
