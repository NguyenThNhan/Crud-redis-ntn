package com.example.crudredisntn.repository;


import com.example.crudredisntn.entity.Employee;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public EmployeeRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void save(Employee employee) {
        hashOperations.put("employee", employee.getId(),employee);
    }

    public List<Employee> findAll() {
        return hashOperations.values("employee");
    }

    public void delete(Long id) {
        hashOperations.delete("employee", id);
    }

    public Employee findById(long id) {
        return (Employee) hashOperations.get("employee", id);
    }
    public void update(Employee employee){
        save(employee);
    }


}
