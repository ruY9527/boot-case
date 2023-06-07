package com.iyang.rocketmq;

import com.iyang.rocketmq.producer.SpringProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/****
 * author: BaoYang
 * date: 2023/6/7
 * desc:
 ***/

@RestController
@SpringBootApplication
public class RocketMqSelfApplication {

    @Autowired
    private SpringProducer springProducer;

    @GetMapping("/send")
    public void send(@RequestParam("msg") String msg){

        springProducer.sendMessage("testQueue", msg);

    }

    @GetMapping("/sendMessageInTransaction")
    public void sendMessageInTransaction() throws Exception {

        springProducer.sendMessageInTransaction("test","BaoYangTransction...");

    }

    public static void main(String[] args) {

        // destination 的 值为 ;   目的：topic:tag，如果不指定则发往配置的默认地址
        // RocketMQHeaders
        SpringApplication.run(RocketMqSelfApplication.class, args);

    }

}
