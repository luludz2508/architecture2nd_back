package com.rmit.secondsead.repository;

import com.rmit.secondsead.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByExperienceGreaterThan(int experience);

    Employee findByPhoneContains(String phone);
}
