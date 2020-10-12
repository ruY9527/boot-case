package com.yang.bootkafkacase.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.websocket.SendResult;

/**
 * Created by Yang on 2020/10/12 22:14
 *
 *
 * 生产数据: 失败可以走失败的回调,成功可以走成功的回调.
 * 如果下游的kafka是宕机的话,没有该回调的话,数据就有可能会丢失,这对于数据严格的情况,肯定是不容许发生的现象.
 */

@Service
public class GavinGroupProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(GavinGroupProvider.class);

    @Value("${gavin.test.topic:gavin.test.topic}")
    private String topicName;

    @Autowired
    private KafkaTemplate kafkaTemplate;


    public void sendMessage(){

        String data = "GavinYang is big brother.";
        ListenableFuture future = kafkaTemplate.send(topicName, data);
        future.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable throwable) {

                // 如果失败了
                LOGGER.error("The failed data is : {} " , data);
            }

            @Override
            public void onSuccess(Object data) {

                LOGGER.debug("The success data is : {} " , data);
            }
        });

    }


}
