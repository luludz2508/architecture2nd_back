package com.rmit.secondsead.controller;

//import com.rmit.secondsead.engine.Producer;

import com.rmit.secondsead.model.Employee;
import com.rmit.secondsead.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    //KAFKA
//    @Autowired
//    private Producer producer;
//
//    @PostMapping(value = "/updEmployee/kafka")
//    public boolean updateEmployeeKafka(@RequestBody Employee employee){
//
//        return  producer.sendUpdateEmployee(employee);
//    }


    @PostMapping(path = "/delemployees")
    public List<Employee> deleteEmployees(@RequestBody List<Employee> employeeList) {

        return employeeService.delEmployees(employeeList);
    }

    @PostMapping(path = "/employee")
    public Employee addEmployee(@RequestBody Employee employee) {

        return employeeService.addEmployee(employee);
    }

    @PostMapping(path = "/employee/login/phone={phone}&pin={pin}")
    public Boolean loginEmployee(@PathVariable String phone, @PathVariable String pin) {
        return employeeService.loginEmployee(phone, pin);
    }

    @PostMapping(path = "/employee/signup")
    public Employee registerEmployee(@RequestBody Employee employee) {
        return employeeService.registerEmployee(employee);
    }

    @PostMapping(path = "/employees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employeeList) {
        System.out.println("Adding " + employeeList.size() + " employees");
        System.out.println(employeeList.get(0).getEid());
        return employeeService.addEmployees(employeeList);
    }

    @GetMapping(path = "/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/employee/{id}")
    public Employee getEmployeeByid(@PathVariable long id) {
        return employeeService.findEmployeeById(id);
    }

    @GetMapping(path = "/employee/phone={phone}")
    public Employee getEmployeeByPhone(@PathVariable("phone") String phone) {
        return employeeService.getEmployeeByPhone(phone);
    }


    @PostMapping(path = "/employee/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.delEmployee(id);
    }

    @PutMapping(path = "/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updEmployee(employee);
    }
}
