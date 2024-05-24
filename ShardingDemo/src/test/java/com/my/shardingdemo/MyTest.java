package com.my.shardingdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.my.shardingdemo.mapper.CourseMapper;
import com.my.shardingdemo.mapper.EmployeesMapper;
import com.my.shardingdemo.pojo.Course;
import com.my.shardingdemo.pojo.Employees;
import com.my.shardingdemo.pojo.EmployeesExample;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class MyTest {



    @Autowired
    private EmployeesMapper employeesMapper;
    @Autowired
    private CourseMapper courseMapper;


    @Test
    public void test() {
        EmployeesExample employeesExample = new EmployeesExample();
        employeesMapper.selectByExample(employeesExample).forEach(System.out::println);
    }

    @Test
    public void testReadCourse() {
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.eq("status", "正常");
        List<Course> courses = courseMapper.selectList(courseQueryWrapper);
        courses.forEach(System.out::println);
    }

    @Test
    public void insert() {

    }
}
