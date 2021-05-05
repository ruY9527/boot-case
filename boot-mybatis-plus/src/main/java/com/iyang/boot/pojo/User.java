package com.iyang.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 实体类  User
 *
 * @Author: Mu_YI
 * @Date: 2019/7/13 22:01
 * @Version 1.0
 */

@TableName(value = "users")
@Data
public class User {

    /**
     * 主键ID
     */
    @TableId
    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮件
     */
    private String email;

    public User() {

    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
