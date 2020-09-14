package com.ercan.service;


import com.ercan.repository.EmployeeRepository;
import com.ercan.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getbyId(Long employee_id) {
        return employeeRepository.findById(employee_id).get();
    }

    @Override
    public Employee saveEmployeeDetails(Employee employeeDetails) {
        return employeeRepository.save(employeeDetails);
    }

    @Override
    public void deleteEmployeDetails(Long employeeDetails_id) {
             employeeRepository.deleteById(employeeDetails_id);
    }
    @Override
    public Employee findUserByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }
    @Override
    public List<Employee> getEmployeesRest() {
        return employeeRepository.getEmployeesRest();
    }
    @Override
    public Employee getIzinSayisiGuncelle(Long id, int alinanIzin){
        Employee employee=getbyId(id);
        int kalan_izin=employee.getKalan_izin()-alinanIzin;
        employee.setKalan_izin(kalan_izin);
        return employee;
    }
}
