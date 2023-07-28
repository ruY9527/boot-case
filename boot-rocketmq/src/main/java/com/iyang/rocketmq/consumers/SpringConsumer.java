package com.iyang.rocketmq.consumers;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/****
 * author: BaoYang
 * date: 2023/6/7
 * desc:
 ***/

@Component
@RocketMQMessageListener(consumerGroup = "${test.topic.consumer}", topic = "${test.topic.name}")
public class SpringConsumer implements RocketMQListener<String> , RocketMQPushConsumerLifecycleListener {


    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void onMessage(String message) {


        System.out.println("Received message : "+ message);



    }


    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {

        // consumer.setMaxReconsumeTimes(3);


    }

}
