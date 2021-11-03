package com.ercan.service;


import com.ercan.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee getbyId(Long employeeId);

    public Employee saveEmployeeDetails(Employee employeeDetails);

    public void deleteEmployeDetails(Long employeeDetailsId);

    public Employee findUserByUsername(String username);

    public Employee getIzinSayisiGuncelle(Long id, int alinanIzin);


}
