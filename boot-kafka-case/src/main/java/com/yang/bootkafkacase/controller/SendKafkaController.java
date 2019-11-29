package com.yang.bootkafkacase.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

@RestController
@RequestMapping("/kafka")
public class SendKafkaController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/send")
    public Object send(String param){
        Map<Object,Object> dataMap = new HashMap<>(16);
        dataMap.put("name","Gavin");
        dataMap.put("age",189);
        dataMap.put("flag",param);

        boolean isFalg = true;
        try{
            kafkaTemplate.send("gavin.test.topic", JSONObject.toJSONString(dataMap));
        }catch (Exception e){
            e.printStackTrace();
            isFalg = false;
        }
        return isFalg?"Send Successed":"Send Failed";
    }

}
