package com.ercan.service;


import com.ercan.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee getbyId(Long employee_id);

    public Employee saveEmployeeDetails(Employee employeeDetails);

    public void deleteEmployeDetails(Long employeeDetails_id);

    public Employee findUserByUsername(String username);

    public Employee getIzinSayisiGuncelle(Long id, int alinanIzin);

    public List<Employee> getEmployeesRest();

}
