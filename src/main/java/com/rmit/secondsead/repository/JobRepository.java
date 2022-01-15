package com.rmit.secondsead.repository;

import com.rmit.secondsead.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findAllByEmployerEid(@Param("eid") long eid);

    @Query("SELECT j FROM Job j WHERE j.employer.eid = :eid ORDER BY j.date DESC")
    Page<Job> findAllByEmployerEid(@Param("eid") long eid, Pageable pageable);

    @Query("SELECT j FROM Job j WHERE LOWER(j.category) LIKE LOWER(CONCAT('%',:category,'%')) and LOWER(j.title) LIKE LOWER(CONCAT('%',:searchStr,'%'))  order by j.date DESC")
    Page<Job> findAllByCategoryContains(Pageable pageable, String category, String searchStr);

}
