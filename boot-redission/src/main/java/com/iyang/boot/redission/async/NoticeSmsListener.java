package com.iyang.boot.redission.async;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;
import jdk.nashorn.internal.objects.annotations.ScriptClass;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author : luohong
 * @desc :
 * @since : 2021/4/15 / 下午5:43
 */


public class NoticeSmsListener {

    @Autowired
    private AsyncEventBus asyncEventBus;

    // 注册监听器
    @PostConstruct
    public void register(){
        asyncEventBus.register(this);
    }

    @Subscribe
    public void sendSms(){



    }

}
