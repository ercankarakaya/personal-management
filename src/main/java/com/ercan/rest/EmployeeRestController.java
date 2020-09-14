package com.ercan.rest;

import com.ercan.entity.Employee;
import com.ercan.service.EmployeeService;
import com.ercan.service.IzinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private IzinService izinService;

    @GetMapping("/employees")
    public List<Employee> employeeList() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee employee(@PathVariable Long id) {
        return employeeService.getbyId(id);
    }

    @PostMapping("/add-employee")
    public Employee add(@RequestBody Employee employee) {
        employeeService.saveEmployeeDetails(employee);
        return employee;
    }

    @PutMapping(value = "/update-employee")
    public Employee update(@RequestBody Employee emp) {
        employeeService.saveEmployeeDetails(emp);
        return emp;
    }




}
