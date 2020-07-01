package com.iyang.bootsourceread.listener;

import com.iyang.bootsourceread.events.GavinYangSendMessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

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

public class GavinYangSendMessageListener implements ApplicationListener<GavinYangSendMessageEvent> {

    private Logger LOGGER = LoggerFactory.getLogger(GavinYangSendMessageListener.class);

    @Override
    public void onApplicationEvent(GavinYangSendMessageEvent event) {

        LOGGER.info("接受来自 GavinYangSendMessageEvent 数据 : {} " , event.toString());

    }


}
