package com.rmit.secondsead.repository;

import com.rmit.secondsead.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByPhoneContains(String phone);
}
