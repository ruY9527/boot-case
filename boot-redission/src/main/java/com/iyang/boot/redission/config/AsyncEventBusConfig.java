package com.iyang.boot.redission.config;

import com.google.common.eventbus.AsyncEventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

/**
 * @author : luohong
 * @desc :
 * @since : 2021/4/15 / 下午5:41
 */

@Configuration
public class AsyncEventBusConfig {

    @Bean
    public AsyncEventBus asyncEventBus(){
        return new AsyncEventBus(Executors.newFixedThreadPool(100));
    }

}
