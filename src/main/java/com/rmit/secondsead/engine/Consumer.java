package com.rmit.secondsead.engine;//package com.rmit.secondsead.engine;
//
//import com.rmit.secondsead.model.Employee;
//import com.rmit.secondsead.model.Employer;
//import com.rmit.secondsead.model.Job;
//import com.rmit.secondsead.model.JobDTO;
//import com.rmit.secondsead.service.ApplicationService;
//import com.rmit.secondsead.service.EmployeeService;
//import com.rmit.secondsead.service.EmployerService;
//import com.rmit.secondsead.service.JobService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//@Service
//public class Consumer {
//
//    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
//    private static final String APPLIED_EMPLOYEE_TOPIC = "applied_employee";
//
//    @Autowired
//    private ApplicationService applicationService;
//
//    @Autowired
//    private EmployeeService employeeService;
//    @Autowired
//    private JobService jobService;
//    @Autowired
//    private EmployerService employerService;
//
//    private static final String EMPLOYEE_UPDATE_TOPIC = "employee_update";
//
//
//    @KafkaListener(topics = EMPLOYEE_UPDATE_TOPIC, groupId = "employee_update_group_id", containerFactory = "kafkaListenerContainerFactory")
//    public void consume(Employee employee) throws IOException {
//        logger.info(String.format("#### -> Consumed message: employee toString-> %s", employee.toString()));
//
//        employeeService.updEmployee(employee);
//
//    }
//
//    private static final String JOB_CREATE= "job_create";
//
//
//    @KafkaListener(topics = JOB_CREATE, groupId = "job_create_id", containerFactory = "kafkaListenerContainerFactory")
//    public void consume(JobDTO jobDTO) throws IOException {
//        logger.info(String.format("#### -> Consumed message: jobDTO toString-> %s", jobDTO.toString()));
//        Employer employer = employerService.getEmployerByID(jobDTO.getEID());
//
//        Job job= new Job();
//        job.setId(jobDTO.getId());
//        job.setTitle(jobDTO.getTitle());
//        job.setCareerLevel(jobDTO.getCareerLevel());
//        job.setDescription(jobDTO.getDescription());
//        job.setAddress(jobDTO.getAddress());
//        job.setMaxSalary(jobDTO.getMaxSalary());
//        job.setRole(jobDTO.getRole());
//        job.setCategory(jobDTO.getCategory());
//        job.setEmployer(employer);
//        job.setMinSalary(jobDTO.getMinSalary());
//        jobService.addJob(job);
//
//    }
//
//
//
//}
