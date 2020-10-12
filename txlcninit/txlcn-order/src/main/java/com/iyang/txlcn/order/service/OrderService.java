package com.iyang.txlcn.order.service;

import com.iyang.txlcn.entity.Order;
import com.iyang.txlcn.vo.R;

/**
 * @author Yang
 * 当前服务 : txlcn-init
 * @date 2020/10/12 / 17:39
 */
public interface OrderService {

    R createOrder(Order order);

}
