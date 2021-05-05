package com.iyang.boot.redission.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author : luohong
 * @desc :
 * @since : 2021/4/15 / 下午5:52
 */

@Service
public class UserService implements ApplicationEventPublisherAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(String username) {
        // ... 执行注册逻辑
        LOGGER.info("[register][执行用户({}) 的注册逻辑]", username);
        // <2> ... 发布
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this, username));
    }

}
