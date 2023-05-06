package com.my.shardingdemo.controller;

import com.my.shardingdemo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyShardingController {

    @Autowired
    private EmployeesService employeesService;

    /**
     * 根据id拆分表
     */
    @GetMapping("/split/table")
    public void testSplitTable(){
        employeesService.testSplitTable();
    }
}
