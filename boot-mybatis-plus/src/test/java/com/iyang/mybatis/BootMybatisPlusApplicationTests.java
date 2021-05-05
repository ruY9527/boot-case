package com.iyang.mybatis;

import com.iyang.boot.BootMybatisPlusApplication;
import com.iyang.boot.mapper.UserMapper;
import com.iyang.boot.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootMybatisPlusApplication.class)
class BootMybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectUserTest(){

        log.info("开始查询 ---> ");
        List<User> users = userMapper.selectList(null);
        Assert.assertEquals(5,users.size());
        users.forEach(System.out::print);

    }

}
