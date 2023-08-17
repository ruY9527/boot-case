package com.iyang.rocketmq.producer;

import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.messaging.Message;
import javax.annotation.Resource;

/****
 * author: BaoYang
 * date: 2023/6/7
 * desc:
 ***/

@Component
public class SpringProducer {

    @Resource
    private RocketMQTemplate rocketMQTemplate;


    /**
     * 发送普通消息
     * @param topic
     * @param msg
     */
    public void sendMessage(String topic, String msg){

        Message<String> message = MessageBuilder.withPayload(msg).build();
/*        MessageQueue messageQueue = new MessageQueue();
        messageQueue.setQueueId(1);
        messageQueue.setTopic(topic);
        messageQueue.setBrokerName("");*/
        // .setMessageQueue() 指定队列里发送
        rocketMQTemplate.syncSendOrderly(topic, message , "baoyang");

    }

    public void sendMessageInTransaction(String topic, String msg) throws Exception {

        String [] tags = { "TagA", "TagB", "TagC", "TagD" , "TagE" };

        for (int i = 0; i < 10; i++) {

            Message<String> message = MessageBuilder.withPayload(msg).build();
            String destination = topic + ":" + tags[i % tags.length] ;
            TransactionSendResult sendResult = rocketMQTemplate.sendMessageInTransaction(destination, message, destination);

            System.out.printf("%s%n", sendResult);
            Thread.sleep(10);

        }


    }


}
