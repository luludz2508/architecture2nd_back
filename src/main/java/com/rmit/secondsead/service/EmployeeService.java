package com.rmit.secondsead.service;


import com.rmit.secondsead.model.Employee;
import com.rmit.secondsead.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;
//    private final String EmployeeCache = "EMPLOYEE";
//    @Autowired
//    RedisTemplate<String, Object> redisTemplate;
//    private HashOperations<String, Long, Employee> hashOperations;
//
//
//    @PostConstruct
//    private void initializeHashOperations() {
//        hashOperations = redisTemplate.opsForHash();
//    }
//
//    public void saveToCache(Employee employee) {
//        hashOperations.put(EmployeeCache, employee.getEid(), employee);
//    }
    public Employee addEmployee(Employee employee) {
        return this.repository.save(employee);
    }

    public List<Employee> addEmployees(List<Employee> employees) {
        return this.repository.saveAll(employees);
    }

    public void delEmployee(long employee) {
        repository.deleteById(employee);
    }

    public List<Employee> delEmployees(List<Employee> employees) {
        for (Employee employee : employees
        ) {
            delEmployee(employee.getEid());
        }
        return this.repository.findAll();
    }

    public List<Employee> getAllEmployees() {
        return this.repository.findAll();
    }

    public Employee findEmployeeById(Long id){
//        Employee employee = hashOperations.get(EmployeeCache, id);
//
//        if (employee != null) return employee;

        System.out.println("ID: "+id);
//        saveToCache(employee);
        return repository.findById(id).get();

    }


    public Boolean loginEmployee(String phone, String pin) {
        Employee employee = repository.findByPhoneContains(phone);
        if (employee ==  null) return false;
        return employee.getPin().equals(pin);
    }

    public Employee registerEmployee(Employee employee) {
        try {
            if (repository.findByPhoneContains(employee.getPhone()) != null) {
                return null;
            } else {
                int i = ThreadLocalRandom.current().nextInt(100000, 1000000);
                employee.setPin(String.valueOf(i));
                return repository.save(employee);
            }
        } catch (Exception ignored) {
            return null;
        }
    }
    public Employee updEmployee(Employee employee){
        if (repository.findById(employee.getEid()).isPresent()){
            Employee existedEmployee=repository.findById(employee.getEid()).get();
            existedEmployee.setName(employee.getName());
            existedEmployee.setPhone(employee.getPhone());
            existedEmployee.setPin(employee.getPin());
            existedEmployee.setAddress(employee.getAddress());
            existedEmployee.setAge(employee.getAge());
            existedEmployee.setCategory(employee.getCategory());
            existedEmployee.setExperience(employee.getExperience());
            existedEmployee.setGender(employee.getGender());
            existedEmployee.setQualification(employee.getQualification());

//            saveToCache(existedEmployee);
            return repository.save(existedEmployee);
        }
        return null;

    }

    public Employee getEmployeeByPhone(String phone) {
        return repository.findByPhoneContains(phone);
    }
}
