package com.ruY9527.application.events;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

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
public class GavinYangSendMessageEvent extends ApplicationContextEvent {


    private String name;
    private String hobby;

    /*public GavinYangSendMessageEvent() {
    }

    public GavinYangSendMessageEvent(String name, String hobby) {
        this.name = name;
        this.hobby = hobby;
    }*/

    public GavinYangSendMessageEvent(ApplicationContext source) {
        super(source);
        this.name = "GavinYang";
        this.hobby = "绝活";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "GavinYangSendMessageEvent{" + "name='" + name + '\'' + ", hobby='" + hobby + '\'' + '}';
    }
}
