package com.rmit.secondsead.repository;

import com.rmit.secondsead.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
    Employer findByPhoneContains(String phone);
    @Query("SELECT e FROM Employer e WHERE e.phone LIKE %:phone%")
    Employer findByPhone(String phone);
}
