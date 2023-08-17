package com.iyang.sharding.jdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iyang.sharding.jdbc.entity.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/****
 * author: BaoYang
 * date: 2023/6/9
 * desc:
 ***/


public interface CourseMapper extends BaseMapper<Course> {


    @Select("select * from course")
    public List<Course> queryAllCourse();


}
