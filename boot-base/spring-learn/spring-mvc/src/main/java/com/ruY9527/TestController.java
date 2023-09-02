package com.ruY9527;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/****
 * author: BaoYang
 * date: 2023/7/27
 * desc:
 ***/

// @RequestMapping(value = "/test")
@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String test(){

        return "test...";
    }

}
