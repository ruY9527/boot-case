package com.yang.bootsourcelearn.listeners;

import com.yang.bootsourcelearn.events.GavinEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/27 23:51
 * @Version 1.0
 * @qq: 1411091515
 */

@Component
public class GavinYangListener {

    private Logger log  = LoggerFactory.getLogger(GavinYangListener.class);

    @EventListener
    public void handleEventLogger(GavinEvent gavinEvent){


        log.info(" 接受到来自Event的事情是: {} " , gavinEvent.getData());
    }

}
