package com.iyang.txlcn.repository.controller;

import com.iyang.txlcn.repository.service.RepositoryService;
import com.iyang.txlcn.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yang
 * 当前服务 : txlcn-init
 * @date 2020/10/12 / 17:46
 */

@RestController
public class RepositoryController {

    @Autowired
    private RepositoryService service;

    //更改库存
    @PostMapping("/provider/repository/changecount.do")
    public R change(@RequestParam int gid, @RequestParam int count){
        //模拟 库存服务出问题
        return service.changeCount(gid, count);
    }

}
