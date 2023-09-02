package com.ruY9527.application.events;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/27 23:50
 * @Version 1.0
 * @qq: 1411091515
 */


public class GavinEvent extends ApplicationEvent {

    private String data;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public GavinEvent(Object source,String data) {
        super(source);
        /** this.data的重要性. */
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
