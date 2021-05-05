package com.iyang.boot.redission.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author : luohong
 * @desc :
 * @since : 2021/4/15 / 下午5:54
 */

@Service
public class UserRegisterListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRegisterListener.class);

    @EventListener
    public void sendEmail(UserRegisterEvent userRegisterEvent) {
        LOGGER.info("给用户（{}）发送邮件", userRegisterEvent.getUsername());

        try {
            Thread.sleep(1000);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
