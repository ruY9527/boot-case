package com.iyang.txlcn.repository.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author Yang
 * 当前服务 : txlcn-init
 * @date 2020/10/12 / 17:43
 */
public interface RepositoryDao {

    @Update("update t_repository set count=count-#{count} where gid=#{gid}")
    int changeCount(@Param("gid") int gid, @Param("count") int count);

}
