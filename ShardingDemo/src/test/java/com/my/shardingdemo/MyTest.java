package com.my.shardingdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.my.shardingdemo.mapper.CourseMapper;
import com.my.shardingdemo.mapper.EmployeesMapper;
import com.my.shardingdemo.pojo.Course;
import com.my.shardingdemo.pojo.EmployeesExample;
import java.util.List;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    /**
     * 使用HINT强制路由策略。
     * 脱离SQL自己指定分片策略。
     * 强制查询course_1表
     */
    @Test
    public void queryCourseByHint(){
        //强制只查course_1表
        HintManager hintManager = HintManager.getInstance();
        //注意这两个属性，dataSourceBaseShardingValue用于强制分库
        // 强制查course_1表
        //        hintManager.setDatabaseShardingValue(1L);
        hintManager.addTableShardingValue("course","1");
        //select * from course;
        List<Course> courses = courseMapper.selectList(null);
        courses.forEach(course -> System.out.println(course));
        //线程安全，所有用完要注意关闭。
        hintManager.close();
        //hintManager关闭的主要作用是清除ThreadLocal，释放内存。HintManager实现了AutoCloseable接口，所以建议使用try-resource的方式，用完自动关闭。
        //try(HintManager hintManager = HintManager.getInstance()){ xxxx }
    }

    @Test
    public void insert() {
        courseMapper.insert(new Course(1L, "语文", 1L, "正常"));
        courseMapper.insert(new Course(2L, "数学", 2L, "正常"));
        courseMapper.insert(new Course(3L, "英语", 3L, "正常"));
        courseMapper.insert(new Course(4L, "物理", 4L, "正常"));
    }
}
