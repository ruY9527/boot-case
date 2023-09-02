package com.ruY9527.application.init;

import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Configuration;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-28
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

/**
 *
 */
@Configuration
public class GavinYangSmartLifecycle implements SmartLifecycle {

    private volatile boolean running;


    @Override
    public void start() {

        this.running = true;
        new Thread(() -> {
            System.out.println("GavinYangSmartLifecycle Log 输出");
        }).start();

    }

    @Override
    public void stop() {

        System.out.println("stop 方法调用");

        this.running = false;
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }


}
