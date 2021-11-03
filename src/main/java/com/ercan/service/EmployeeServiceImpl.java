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
    public Employee getbyId(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public Employee saveEmployeeDetails(Employee employeeDetails) {
        return employeeRepository.save(employeeDetails);
    }

    @Override
    public void deleteEmployeDetails(Long employeeDetailsId) {
             employeeRepository.deleteById(employeeDetailsId);
    }
    @Override
    public Employee findUserByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

    @Override
    public Employee getIzinSayisiGuncelle(Long id, int alinanIzin){
        Employee employee=getbyId(id);
        int kalanIzin=employee.getKalanIzin()-alinanIzin;
        employee.setKalanIzin(kalanIzin);
        return employee;
    }
}
