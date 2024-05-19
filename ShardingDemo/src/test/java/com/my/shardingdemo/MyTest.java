package com.my.shardingdemo;

import com.my.shardingdemo.mapper.EmployeesMapper;
import com.my.shardingdemo.pojo.Employees;
import com.my.shardingdemo.pojo.EmployeesExample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class MyTest {



    @Autowired
    private EmployeesMapper employeesMapper;


    @Test
    public void test() {
        EmployeesExample employeesExample = new EmployeesExample();
        employeesMapper.selectByExample(employeesExample).forEach(System.out::println);
    }

    @Test
    public void insert() {

        employeesMapper.insert(new Employees(1, "Tom", 20, "Engineer", new Date(), new Date()));
        employeesMapper.insert(new Employees(2, "Jerry", 22, "Manager", new Date(), new Date()));
    }
}
