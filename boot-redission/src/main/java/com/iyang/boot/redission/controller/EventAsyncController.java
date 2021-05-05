package com.iyang.boot.redission.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : luohong
 * @desc :
 * @since : 2021/4/15 / 下午6:12
 */

@RestController
@RequestMapping("/event")
public class EventAsyncController {

    @GetMapping
    public void eventTest(){



    }


}
