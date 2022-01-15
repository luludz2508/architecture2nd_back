package com.rmit.secondsead.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Job implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private String address;

    @Column
    private LocalDateTime date;

    @Column
    private double salary;

    @Column
    private double minSalary;

    @Column
    private double maxSalary;

    @Column
    private String category; // career specialization

    @Column
    private String description;

    @Column
    private int careerLevel; // years of experience

    @Column
    private String role; // full-time/part-time

    @ManyToOne(cascade = CascadeType.MERGE)
    private Employer employer;

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", careerLevel=" + careerLevel +
                ", role='" + role + '\'' +
                ", employer=" + employer +
                '}';
    }
}
