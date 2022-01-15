package com.rmit.secondsead.service;


import com.rmit.secondsead.model.Job;
import com.rmit.secondsead.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepository repository;

//    private final String JobCache = "JOB";
//    @Autowired
//    RedisTemplate<String, Object> redisTemplate;
//    private HashOperations<String, Long, Job> hashOperations;
//
//
//    @PostConstruct
//    private void initializeHashOperations() {
//        hashOperations = redisTemplate.opsForHash();
//    }
//
//    public void saveToCache(Job job) {
//        hashOperations.put(JobCache, job.getId(), job);
//    }

    public Job addJob(Job job) {
        job.setDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return this.repository.save(job);
    }

    public Job findJobByID(Long id) {
//        Job job = hashOperations.get(JobCache, id);
//        if (job != null) return job;
//        else {
//            job = repository.getById(id);
//            saveToCache(job);
//            return job;
//        }
        return repository.getById(id);
    }

    public List<Job> addJobs(List<Job> jobs) {
        return this.repository.saveAll(jobs);
    }

    public void delJob(long job) {
        repository.deleteById(job);
    }

    public List<Job> delJobs(List<Job> jobs) {
        for (Job job : jobs
        ) {
            delJob(job.getId());
        }
        return this.repository.findAll();
    }

    public List<Job> getAllJobsPage(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).getContent();
    }

    public List<Job> getAllJobs() {
        return this.repository.findAll();
    }
//    public List<Job> getAllJobsByEid(long id) {
//        return this.repository.findAllByEmployer_Eid(id).getContent();
//    }

    public Job updJob(Job job) {
        if (repository.findById(job.getId()).isPresent()) {
            Job existedJob = repository.findById(job.getId()).get();
            existedJob.setAddress(job.getAddress());
            existedJob.setCareerLevel(job.getCareerLevel());
            existedJob.setCategory(job.getCategory());
            existedJob.setDescription(job.getDescription());
            existedJob.setRole(job.getRole());
            existedJob.setTitle(job.getTitle());
            existedJob.setDate(job.getDate());
            existedJob.setMaxSalary(job.getMaxSalary());
            existedJob.setMinSalary(job.getMinSalary());
            existedJob.setSalary(job.getSalary());

            //update on reddis
//            saveToCache(existedJob);
            return repository.save(existedJob);
        }
        return null;
    }

    public Page<Job> getAllJobsEmployer(int employerid, int page, int size) {

        Page<Job> tempList = repository.findAllByEmployerEid(employerid, PageRequest.of(page, size));
        System.out.println(repository.findAllByEmployerEid(employerid).size());
        return tempList;
    }

    public Page<Job> searchAllJobsEmployer(int page, int size, String category, String searchStr) {

        return repository.findAllByCategoryContains(PageRequest.of(page, size), category, searchStr);
    }

    public int getAllJobsEmployersize(int employerid) {
        return repository.findAllByEmployerEid(employerid).size();
    }
}
