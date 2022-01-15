package com.rmit.secondsead.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class JobDTO   {
    private Long id;
 
    private String title; 
    private String address;
    private double salary;


    private double minSalary;


    private double maxSalary;


    private String category; // career specialization


    private String description;


    private int careerLevel; // years of experience


    private String role; // full-time/part-time

    private Long eID;

    public JobDTO( ) {
    }

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
                '}';
    }
}
