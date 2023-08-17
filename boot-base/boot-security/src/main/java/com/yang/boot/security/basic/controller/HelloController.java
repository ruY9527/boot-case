package com.yang.boot.security.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Mu_Yi
 * @Date: 2019/12/27 23:35
 * @Version 1.0
 * @qq: 1411091515
 */

@RestController
@RequestMapping("/yang")
public class HelloController {

    @GetMapping("/hello")
    public Object hello(){
        return "Hello;Gavin!!!";
    }

}
