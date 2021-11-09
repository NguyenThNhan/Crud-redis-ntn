package com.example.crudredisntn.controller;

import com.example.crudredisntn.entity.Employee;
import com.example.crudredisntn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){

        return employeeRepository.findAll();
    }
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable("id") Long id){

        return employeeRepository.findById(id);
    }

    @PutMapping("/employee}")
    public void update(@RequestBody Employee employee){

        employeeRepository.update(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable("id") Long id){
        employeeRepository.delete(id);
    }
}
