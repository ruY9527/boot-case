package com.iyang.rocketmq.pojos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/****
 * author: BaoYang
 * date: 2023/6/7
 * desc:
 ***/

@Data
public class RocketMqMessage {


    private Long id;
    private String message;
    private String version;
    private LocalDate currentDate;
    private LocalDateTime currentDateTime;



}
