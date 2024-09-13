package com.spring_boot.redis.controller;

import com.spring_boot.redis.entity.Employee;
import com.spring_boot.redis.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping()
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") Long id){
        return employeeService.getById(id).get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        employeeService.delete(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable("id") Long id, @RequestBody Employee employee){
        return employeeService.update(employee, id);
    }

    @GetMapping()
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
}
