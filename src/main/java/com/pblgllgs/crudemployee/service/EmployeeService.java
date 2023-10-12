package com.pblgllgs.crudemployee.service;

import com.pblgllgs.crudemployee.entity.Employee;

import java.util.List;

public interface EmployeeService{
    List<Employee> findAll();

    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
    Employee update(Employee employee);
}
