package com.rmit.secondsead.controller;

//import com.rmit.secondsead.engine.Producer;

import com.rmit.secondsead.model.Job;
import com.rmit.secondsead.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Slf4j
public class JobController {
    @Autowired
    private JobService jobService;

    //KAFKA
//    @Autowired
//    private Producer producer;
//
//    @PostMapping(value = "/createJob/kafka")
//    public boolean createJob(@RequestBody JobDTO jobDTO){
//
//        return  producer.createJob(jobDTO);
//    }


    @PostMapping(path = "/deljobs")
    public List<Job> deleteJobs(@RequestBody List<Job> jobList) {

        return jobService.delJobs(jobList);
    }

    @PostMapping(path = "/job")
    public Job addJob(@RequestBody Job job) {

        return jobService.addJob(job);
    }
    @GetMapping(path = "/job/{id}")
    public Job getJob(@PathVariable Long id) {

        return jobService.findJobByID(id);
    }

    @PostMapping(path = "/jobs")
    public List<Job> addJobs(@RequestBody List<Job> jobList) {
        System.out.println("Adding " + jobList.size() + " jobs");
        System.out.println(jobList.get(0).getId());
        return jobService.addJobs(jobList);
    }

    @GetMapping(path = "/jobs")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

//    @GetMapping(path = "/job/{id}")
//    public List<Job> getJobsByid(@RequestParam long id) {
//        return jobService.getAllJobsByEid(id);
//    }

//    @GetMapping(path = "/jobs/eid={id}")
//    public List<Job> getAllJobs(@PathVariable long id) {
//        return jobService.getAllJobsByEid(id);
//    }

    @GetMapping(path = "/jobs/page/page={page}&size={size}")
    public List<Job> getAllJobs(@PathVariable("page") int page, @PathVariable("page") int size) {
        return jobService.getAllJobsPage(page, size);
    }

    @GetMapping(path = "/jobs/employerpage/employer={employerid}&page={page}&size={size}")
    public Page<Job> getAllJobs(@PathVariable("employerid") int employerid, @PathVariable("page") int page, @PathVariable("size") int size) {
        return jobService.getAllJobsEmployer(employerid,page, size);
    }
//    @GetMapping(path = "/jobs/employerpage/employer={employerid}&page={page}&size={size}")
//    public Page<Job> searchAllJobs(@PathVariable("employerid") int employerid, @PathVariable("page") int page, @PathVariable("size") int size) {
//        return jobService.getAllJobsEmployer(employerid,page, size);
//    }
    @GetMapping(path = "/jobs/search/page={page}&size={size}&search={search}&category={category}")
    public Page<Job> searchAllJobs(@PathVariable("page") int page, @PathVariable("size") int size, @PathVariable("search") String search, @PathVariable("category") String category) {
        System.out.println(category);
        return jobService.searchAllJobsEmployer(page, size,category,search);
    }
    @GetMapping(path = "/jobs/employer/employer={employerid}")
    public int getAllJobsSize(@PathVariable("employerid") int employerid) {
        return jobService.getAllJobsEmployersize(employerid);
    }

    @DeleteMapping(path = "/job/{id}")
    public void deleteJob(@PathVariable int id) {
        jobService.delJob(id);
    }

    @PutMapping(path = "/job")
    public Job updateJob(@RequestBody Job job) {
        return jobService.updJob(job);
    }

}
