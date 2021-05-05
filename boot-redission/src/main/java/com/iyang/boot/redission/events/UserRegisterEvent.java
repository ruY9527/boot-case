package com.iyang.boot.redission.events;

import org.springframework.context.ApplicationEvent;

/**
 * @author : luohong
 * @desc :
 * @since : 2021/4/15 / 下午5:49
 */

public class UserRegisterEvent extends ApplicationEvent {

    private String username;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
