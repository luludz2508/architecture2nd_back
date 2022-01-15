package com.rmit.secondsead.service;


import com.rmit.secondsead.model.Application;
import com.rmit.secondsead.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    ApplicationRepository repository;

    public Application addApplication(Application application) {

        return this.repository.save(application);
    }

    public List<Application> addApplications(List<Application> applications) {
        return this.repository.saveAll(applications);
    }

    public void delApplication(long application) {
        repository.deleteById(application);
    }

    public List<Application> delApplications(List<Application> applications) {
        for (Application application : applications
        ) {
            delApplication(application.getAid());
        }
        return this.repository.findAll();
    }

    public List<Application> getAllApplications() {
        return this.repository.findAll();
    }

    public Application updApplication(Application application){
        Application existedApplication=repository.findById(application.getAid()).get();
        existedApplication.setEmployee(application.getEmployee());
        existedApplication.setJob(application.getJob());

        return repository.save(existedApplication);
    }
}
