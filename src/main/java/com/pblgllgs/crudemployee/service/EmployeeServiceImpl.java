package com.pblgllgs.crudemployee.service;

import com.pblgllgs.crudemployee.entity.Employee;
import com.pblgllgs.crudemployee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Employee update(Employee employee) {
        Employee employeeDB = employeeRepository.findById(employee.getId()).orElseThrow( () -> new RuntimeException("NOT FOUND"));
        employeeDB.setFirstName(employee.getFirstName());
        employeeDB.setLastName(employee.getLastName());
        employeeDB.setEmail(employee.getEmail());
        return employeeRepository.save(employeeDB);
    }
}
