package com.rmit.secondsead.repository;

import com.rmit.secondsead.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
