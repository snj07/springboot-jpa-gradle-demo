package com.snj.controller;


import com.snj.entities.Employee;
import com.snj.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createCustomer(employee);
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
