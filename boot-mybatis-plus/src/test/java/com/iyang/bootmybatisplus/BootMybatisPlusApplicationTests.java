package com.iyang.bootmybatisplus;

import com.iyang.bootmybatisplus.mapper.UserMapper;
import com.iyang.bootmybatisplus.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootMybatisPlusApplicationTests {

    @SuppressWarnings("all")
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试添加UserInfo的Test
     */
    @Test
    public void addUserInfoTest(){
        User userInfo = new User("Yang",12,"1411091515@qq.com");
        userMapper.insert(userInfo);
    }

    /**
     * 根据ID来进行更新
     */
    @Test
    public void updateById(){
        User updateUser = new User("Yang Update",23,null);
        updateUser.setId(1150048962208645121L);
        userMapper.updateById(updateUser);
    }

    /**
     * 根据Id来查询User信息
     */
    @Test
    public void selectUserById(){
        User user = userMapper.selectById(1150048962208645121L);
        System.out.println("UserById:" + user);
    }

    /**
     * 条件查询等
     */
    @Test
    public void selectUserByUserColume(){
        Integer countNumber = userMapper.selectCount(null);
        System.out.println("Count:" + countNumber);

        // 根据字段条件来进行查询
        Map<String,Object> conditionMap = new HashMap<>();
        conditionMap.put("name","Yang Update");
        List<User> userList = userMapper.selectByMap(conditionMap);
        System.out.println("userList:" + userList);
    }

    /**
     * 根据Id来进行删除
     */
    @Test
    public void deleteById(){

        int count = userMapper.deleteById(1150048962208645121L);

        System.out.println(count > 0 ? "删除成功" : "删除失败");
    }

}
