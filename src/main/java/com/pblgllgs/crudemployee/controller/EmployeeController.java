package com.pblgllgs.crudemployee.controller;

import com.pblgllgs.crudemployee.entity.Employee;
import com.pblgllgs.crudemployee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployees() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("employeeId") int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("EMPLOYEE NOT FOUND!");
        }
        return new ResponseEntity<>(employeeService.findById(employeeId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee) {
        Employee employeeDB = employeeService.findById(employee.getId());
        if (employeeDB == null) {
            throw new RuntimeException("EMPLOYEE NOT FOUND!");
        }
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.save(employee),HttpStatus.CREATED);
    }


    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable("employeeId") int employeeId) {
        Employee employeeDB = employeeService.findById(employeeId);
        if (employeeDB == null) {
            throw new RuntimeException("EMPLOYEE NOT FOUND!");
        }
        employeeService.deleteById(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
