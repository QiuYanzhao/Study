package com.my.shardingdemo.service.impl;

import com.my.shardingdemo.mapper.EmployeesMapper;
import com.my.shardingdemo.pojo.Employees;
import com.my.shardingdemo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
* @author qyz
* @description 针对表【employees(员工记录表)】的数据库操作Service实现
* @createDate 2023-05-03 20:27:11
*/
@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    private EmployeesMapper employeesMapper;


    @Override
    public void testSplitTable() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Employees employees = new Employees();
            int j = random.nextInt(1000);
            employees.setName("name" + j);
            employeesMapper.insert(employees);
        }
    }
}




