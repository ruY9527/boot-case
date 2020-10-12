package com.iyang.txlcn.repository.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.iyang.txlcn.repository.dao.RepositoryDao;
import com.iyang.txlcn.repository.service.RepositoryService;
import com.iyang.txlcn.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yang
 * 当前服务 : txlcn-init
 * @date 2020/10/12 / 17:45
 */
public class RepositoryServiceImpl implements RepositoryService {

    @Autowired
    private RepositoryDao dao;


    @LcnTransaction
    @Transactional
    @Override
    public R changeCount(int gid, int count) {
        System.err.println("库存服务："+gid);
        if(dao.changeCount(gid, count)>0){
            System.out.println("返回是OK的");
            return R.ok();
        }else {
            System.out.println("返回是有问题的");
            return R.fail();
        }
    }
}
