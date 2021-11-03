package com.ercan.repository;

import com.ercan.entity.Employee;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {


    final String url = "http://dummy.restapiexample.com/api/v1/employees";
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Employee> getEmployees() {
      ResponseEntity<List<Employee>> respEntity = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Employee>>() {
               });
        return respEntity.getBody();

    }

}
