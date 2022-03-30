package com.mvc.spring.dao;

import com.mvc.spring.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAll();

    public Employee get(Long id);

    public void create(Employee employee);

    public void delete(Long id);
}
