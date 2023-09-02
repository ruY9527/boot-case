package com.yang.dubbo.consumer.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yang.dubbo.common.service.PersonService;
import com.yang.dubbo.common.vo.R;
import io.swagger.annotations.Api;

@RestController
@Api(value = "控制器操作人",tags = "控制器操作人")
public class PersonController {

	@Reference(version = "1.0.0",retries = 0,timeout = 10000)
	private PersonService personService;
	
    @GetMapping("api/person/all.do")
    public R all(){
        return personService.queryAll();
    }
	
}
