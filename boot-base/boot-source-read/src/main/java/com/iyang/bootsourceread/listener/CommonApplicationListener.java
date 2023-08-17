package com.iyang.bootsourceread.listener;

import com.iyang.bootsourceread.events.GavinYangSendMessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.ResolvableType;

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

public class CommonApplicationListener implements GenericApplicationListener {

    private Logger LOGGER = LoggerFactory.getLogger(CommonApplicationListener.class);

    @Override
    public boolean supportsEventType(ResolvableType eventType) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ApplicationStartingEvent){
            LOGGER.info(" CommonApplicationListener 接受到 ApplicationStartingEvent ");
        } else if (event instanceof GavinYangSendMessageEvent){
            LOGGER.info(" CommonApplicationListener 接受到 ApplicationStartingEvent  ");
        } else {
            LOGGER.info(" 接受到 既不是 ApplicationStartingEvent ; 也不是 ApplicationStartingEvent");
        }

        LOGGER.info(" CommonApplicationListener 中 class全名字是 : {} " , event.getClass().toString());

    }
}
