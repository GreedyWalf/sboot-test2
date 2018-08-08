package com.sboot.test4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpaController {
    @Autowired
    private EmployeeRepository repository;


    @RequestMapping(value = "/findByEmpName")
    public String findByEmpName(){
        repository.save(new Employee("zhangsan"));
        repository.save(new Employee("lisi"));
        repository.save(new Employee("wangwu"));

        return repository.findByEmployeeName("zhangsan").getEmployeeName();
    }
}