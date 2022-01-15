package com.rmit.secondsead.service;


import com.rmit.secondsead.model.Employer;
import com.rmit.secondsead.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class EmployerService {

    @Autowired
    EmployerRepository repository;
//    private final String EmployerCache = "EMPLOYER";
//    @Autowired
//    RedisTemplate<String, Object> redisTemplate;
//    private HashOperations<String, Long, Employer> hashOperations;
//
//
//    @PostConstruct
//    private void initializeHashOperations() {
//        hashOperations = redisTemplate.opsForHash();
//    }
//
//    public void saveToCache(Employer employer) {
//        hashOperations.put(EmployerCache, employer.getEid(), employer);
//    }
    public Employer addEmployer(Employer employer) {
        return this.repository.save(employer);
    }

    public List<Employer> addEmployers(List<Employer> employers) {
        return this.repository.saveAll(employers);
    }

    public void delEmployer(long employer) {
        repository.deleteById(employer);
    }

    public List<Employer> delEmployers(List<Employer> employers) {
        for (Employer employer : employers
        ) {
            delEmployer(employer.getEid());
        }
        return this.repository.findAll();
    }

    public Employer getEmployerByID(Long id){
        return repository.getById(id);
    }
    public Employer updEmployer(Employer employer) {
        if (repository.findById(employer.getEid()).isPresent()) {

            Employer existedEmployer = repository.findById(employer.getEid()).get();
            existedEmployer.setName(employer.getName());
            existedEmployer.setPhone(employer.getPhone());
            existedEmployer.setPin(employer.getPin());
            existedEmployer.setAddress(employer.getAddress());

            //savve to reddis
//            saveToCache(existedEmployer);
            return repository.save(existedEmployer);
        }
        return null;
    }

    public List<Employer> getAllEmployers() {
        return this.repository.findAll();
    }

    public Boolean loginEmployer(String phone, String pin) {
        System.out.println("loginEmployer: "+phone);
        System.out.println("loginEmployer: "+pin);
        Employer employer = repository.findByPhoneContains(phone);
        return employer.getPin().equals(pin);
    }

    public Employer registerEmployer(Employer employer) {
        try {
            if (repository.findByPhoneContains(employer.getPhone()) != null) {
                return null;
            } else {
                int i = ThreadLocalRandom.current().nextInt(100000, 1000000);
                employer.setPin(String.valueOf(i));

                return repository.save(employer);
            }
        } catch (Exception ignored) {
            return null;

        }
    }

    public Employer getEmployerByPhone(String phone) {
        System.out.println("getEmployerByPhone "+phone);
        return repository.findByPhoneContains(phone);
    }
}
