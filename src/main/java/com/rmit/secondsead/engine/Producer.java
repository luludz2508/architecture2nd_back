package com.rmit.secondsead.engine;//package com.rmit.secondsead.engine;
//
//import com.rmit.secondsead.model.Employee;
//import com.rmit.secondsead.model.Job;
//import com.rmit.secondsead.model.JobDTO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class Producer {
//
//    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
//
//    @Autowired
//    private KafkaTemplate<String, Object> kafkaTemplate;
//
//    private static final String EMPLOYEE_UPDATE_TOPIC = "employee_update";
//
//    public boolean sendUpdateEmployee(Employee employee){
//        try {
//            logger.info(String.format("#### -> Producing updating employee object message -> employee name -> %s", employee.getName()));
//            kafkaTemplate.send(EMPLOYEE_UPDATE_TOPIC, employee);
//
//            return true;
//        } catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//
//    }
//
//    //
//
//    private static final String CREATE_JOB = "job_create";
//
//    public boolean createJob(JobDTO jobDTO){
//        try {
//            logger.info(String.format("#### -> Producing updating employee object message -> employee name -> %s", jobDTO.getTitle()));
//            kafkaTemplate.send(CREATE_JOB, jobDTO);
//
//            return true;
//        } catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//
//    }
//
//
//
//
//}