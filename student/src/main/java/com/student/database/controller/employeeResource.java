package com.student.database.controller;

import com.student.database.model.Employee;
import com.student.database.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class employeeResource {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee saveEmployees(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/employee")
    public Iterable<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{empid}")
    Optional<Employee> getEmployees(@PathVariable Integer empid){
        return employeeService.findById(empid);
    }

    @PutMapping("/employee/{empid}")
    public Employee updateEmployee(@PathVariable int empid,@RequestBody Employee employee){
        employee.setEmpid(empid);
        return employeeService.save(employee);
    }
    @DeleteMapping("/employee/{empid}")
    public void deleteEmployee(@PathVariable int empid){
        employeeService.deleteById(empid);
    }
}
