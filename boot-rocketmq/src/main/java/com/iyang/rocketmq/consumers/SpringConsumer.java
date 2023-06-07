package com.iyang.rocketmq.consumers;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/****
 * author: BaoYang
 * date: 2023/6/7
 * desc:
 ***/

@Component
@RocketMQMessageListener(consumerGroup = "${test.topic.consumer}", topic = "${test.topic.name}")
public class SpringConsumer implements RocketMQListener<String> {


    @Override
    public void onMessage(String message) {


        System.out.println("Received message : "+ message);
    }


}
