package com.rmit.secondsead.controller;

import com.rmit.secondsead.model.Application;
import com.rmit.secondsead.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Slf4j
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;



    @PostMapping(path = "/delapplications")
    public List<Application>  deleteApplications(@RequestBody List<Application> applicationList) {

        return applicationService.delApplications(applicationList);
    }

    @PostMapping(path = "/application")
    public Application addApplication(@RequestBody Application application) {

        return applicationService.addApplication(application);
    }
    @PostMapping(path = "/applications")
    public List<Application> addApplications(@RequestBody List<Application> applicationList) {
        System.out.println("Adding "+applicationList.size()+" applications");
        System.out.println(applicationList.get(0).getAid());
        return applicationService.addApplications(applicationList);
    }

    @GetMapping(path = "/applications")
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping(path = "/applications/id={id}")
    public List<Application> getAllApplications(@PathVariable Long id) {
        return applicationService.getAllApplications();
    }

    @PostMapping(path = "/application/{id}")
    public void deleteApplication(@RequestParam int id) {
        applicationService.delApplication(id);
    }

    @PutMapping(path = "/application")
    public Application updateApplication(@RequestBody Application application) {
        return applicationService.updApplication(application);
    }

}
