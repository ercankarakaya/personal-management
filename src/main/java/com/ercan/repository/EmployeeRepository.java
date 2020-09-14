package com.ercan.repository;

import com.ercan.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>,EmployeeRepositoryCustom {
    Employee findByUsername(String username);

}
