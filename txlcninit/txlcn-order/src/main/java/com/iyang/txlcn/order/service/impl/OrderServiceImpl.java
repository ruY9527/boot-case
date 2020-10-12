package com.iyang.txlcn.order.service.impl;

import com.iyang.txlcn.entity.Order;
import com.iyang.txlcn.order.dao.OrderDao;
import com.iyang.txlcn.order.provider.RepositoryService;
import com.iyang.txlcn.order.service.OrderService;
import com.iyang.txlcn.vo.R;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Yang
 * 当前服务 : txlcn-init
 * @date 2020/10/12 / 17:39
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao dao;
    @Autowired
    private RepositoryService service;

    @Override
    public R createOrder(Order order) {
        //本地事务就是指Connection上面的是
        //远程服务 分布式事务
        //生成订单
        dao.save(order);
        //更改库存---->调用库存服务--->完成库存变更
        service.change(order.getGid(), 1);

        //模拟异常 如果事务成功：不仅仅订单无效 库存更改也要回滚
        if(order.getGid()==11){
            System.out.println(1/0);
        }
        return R.ok();
    }

}
