package com.ercan.service;


import com.ercan.repository.EmployeeRepository;
import com.ercan.details.MyEmployeeDetails;
import com.ercan.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class EmployeeDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);

        if (employee == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyEmployeeDetails(employee);

    }
}
