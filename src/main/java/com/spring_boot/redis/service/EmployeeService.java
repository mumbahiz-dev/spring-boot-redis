package com.spring_boot.redis.service;

import com.spring_boot.redis.entity.Employee;
import com.spring_boot.redis.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @CacheEvict(value = "employees", allEntries = true)
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Cacheable(value = "employees", key = "#id")
    public Optional<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }

    @CacheEvict(value = "employees", key = "#id")
    public void delete(Long id){
        employeeRepository.deleteById(id);
    }

    @Cacheable(value = "employees", keyGenerator = "customKeyGenerator")
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @Transactional
    @CacheEvict(value = "employees", allEntries = true)
    public Employee update(Employee employee, Long id) {
        Optional<Employee> employeeExist = employeeRepository.findById(id);
        if (employeeExist.isPresent()){
            employeeExist.get().setName(employee.getName());
            employeeExist.get().setPosition(employee.getPosition());
            return employeeExist.get();
        }

        return null;
    }
}
