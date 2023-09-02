package com.ruY9527.application.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.core.Ordered;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-7-1
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

public class GavinYangEventPublishingRunListener implements SpringApplicationRunListener, Ordered {

    private Logger LOGGER = LoggerFactory.getLogger(GavinYangEventPublishingRunListener.class);

    private SpringApplication application;
    private String[] args;

    public GavinYangEventPublishingRunListener() {

    }

    public GavinYangEventPublishingRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
        System.out.println("调用到了 private final String[] args; 有参数构造方法");
    }

    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * org.springframework.boot.SpringApplication#run(java.lang.String...).
     * listeners.starting(); 当走到这个方法的时候,就会调用到.
     *
     */
    public void starting() {

        LOGGER.info("GavinYangEventPublishingRunListener 调用 starting 方法成功");

    }

}
