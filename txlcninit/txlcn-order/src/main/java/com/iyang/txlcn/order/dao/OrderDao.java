package com.iyang.txlcn.order.dao;

import com.iyang.txlcn.entity.Order;
import org.apache.ibatis.annotations.Insert;

/**
 * @author Yang
 * 当前服务 : txlcn-init
 * @date 2020/10/12 / 17:37
 */
public interface OrderDao {

    @Insert("insert into t_order(gid,oid,flag) values(#{gid},#{oid},1)")
    int save(Order order);

}
