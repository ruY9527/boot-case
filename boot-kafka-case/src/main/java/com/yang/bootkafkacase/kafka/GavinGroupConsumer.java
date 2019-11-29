package com.yang.bootkafkacase.kafka;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-11-29
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

@Component
@Slf4j
public class GavinGroupConsumer {


    /**
     * 如果这条数据出现异常没有ACK,下次也不会获取出这条没有ACK的数据
     * Kafka跳过了这条没有ACK的数据,拿取出的一下条,而下条的数据如果是没有问题的,就是出现ACK,而那个出现错误没有ACK也跳过去了,消息只拿了一次.
     *
     *
     *
     * @param records
     * @param ack
     */
    @KafkaListener(topics = "${gavin.test.topic}",containerFactory = "gavinBatchFactory")
    public void listen(List<ConsumerRecord<?, ?>> records, Acknowledgment ack) {
        Optional<?> kafkaMessage = Optional.ofNullable(records);
        if (kafkaMessage.isPresent()) {
            log.info("records  data ----> {} ",records);
            Object value = records.get(0).value();
            log.info("records contains ---> {} ",JSONObject.toJSONString(value));
            if(!JSONObject.toJSONString(value).contains("true")){
                int i = 1 / 0;
            }
        }
        ack.acknowledge();
        log.info("------------------ACK------------------");
    }

}
