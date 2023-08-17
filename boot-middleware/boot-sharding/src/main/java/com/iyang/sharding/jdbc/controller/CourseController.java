package com.iyang.sharding.jdbc.controller;

import com.iyang.sharding.jdbc.entity.Course;
import com.iyang.sharding.jdbc.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/****
 * author: BaoYang
 * date: 2023/6/9
 * desc:
 ***/


@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseMapper courseMapper;

    @GetMapping("add")
    public void add(){

        for (int i = 0; i < 10; i++) {

            Course course = new Course();
            course.setCname("java" + i);
            course.setUserId(9527L);
            course.setCstatus("123");

            int insertCount = courseMapper.insert(course);

            System.out.println("插入的个数: " + insertCount);
        }

    }


}
