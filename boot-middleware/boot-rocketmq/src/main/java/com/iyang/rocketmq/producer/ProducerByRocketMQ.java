package com.iyang.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/****
 * author: BaoYang
 * date: 2023/6/8
 * desc: 官网例子
 ***/
public class ProducerByRocketMQ {


    /**
     * 同步发送消息
     * @throws Exception
     */
    public static void syncSendMessage() throws Exception {

        DefaultMQProducer producer = new DefaultMQProducer("baoYangTestProducer");
        producer.setNamesrvAddr("172.21.129.80:9876");
        producer.start();

        for (int i = 0; i < 100; i++) {
            Message msg = new Message("TopicTest" /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " + i).getBytes() /* Message body */
            );   //（3）
            // 利用producer进行发送，并同步等待发送结果

            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }

        producer.shutdown();

    }


    public static void asyncSendMessage() throws Exception {

        DefaultMQProducer producer = new DefaultMQProducer("baoYangTestProducerAsync");
        // 设置NameServer地址
        producer.setNamesrvAddr("172.21.129.80:9876");
        // 启动producer
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);
        int messageCount = 100;
        final CountDownLatch countDownLatch = new CountDownLatch(messageCount);

        for (int i = 0; i < messageCount; i++) {

            final  int index = i;
            Message msg = new Message("TopicTest", "TagA", "Hello world".getBytes());

            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {

                }

                @Override
                public void onException(Throwable e) {

                }
            });

        }

        countDownLatch.await(5, TimeUnit.SECONDS);
        producer.shutdown();
    }


}
