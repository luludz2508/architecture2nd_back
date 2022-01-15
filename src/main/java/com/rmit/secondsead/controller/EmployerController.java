package com.rmit.secondsead.controller;

import com.rmit.secondsead.model.Employer;
import com.rmit.secondsead.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
//@Slf4j
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @PostMapping(path = "/delemployers")
    public List<Employer>  deleteEmployers(@RequestBody List<Employer> employerList) {

        return employerService.delEmployers(employerList);
    }

    @PostMapping(path = "/employer")
    public Employer addEmployer(@RequestBody Employer employer) {

        return employerService.addEmployer(employer);
    }
    @PostMapping(path = "/employers")
    public List<Employer> addEmployers(@RequestBody List<Employer> employerList) {
        System.out.println("Adding "+employerList.size()+" employers");
        System.out.println(employerList.get(0).getEid());
        return employerService.addEmployers(employerList);
    }

    @GetMapping(path = "/employers")
    public List<Employer> getAllEmployers() {
        return employerService.getAllEmployers();
    }
    @GetMapping(path = "/employer/phone={phone}")
    public Employer getEmployerbyPhone(@PathVariable String phone) {
        System.out.println("getEmployerbyPhone");
        return employerService.getEmployerByPhone(phone);
    }

    @PostMapping(path = "/employer/{id}")
    public void deleteEmployer(@RequestParam int id) {
        employerService.delEmployer(id);
    }
    @PostMapping(path = "/employer/login/phone={phone}&pin={pin}")
    public Boolean loginEmployer(@PathVariable String phone, @PathVariable String pin) {
        System.out.println(phone);
        System.out.println(phone);

        return employerService.loginEmployer(phone, pin);
    }

    @PostMapping(path = "/employer/signup")
    public Employer registerEmployer(@RequestBody Employer employer) {
        System.out.println(employer.toString());
        return employerService.registerEmployer(employer);
    }

    @PutMapping(path = "/employer")
    public Employer updateEmployer(@RequestBody Employer employer) {
        return employerService.updEmployer(employer);
    }
}
