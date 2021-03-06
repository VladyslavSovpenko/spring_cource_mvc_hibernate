package com.mvc.spring.service;

import com.mvc.spring.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public void addEmployee(Employee employee);
    public Employee get(Long id );
    public void delete(Long id);

}
