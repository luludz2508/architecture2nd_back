package com.rmit.secondsead.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Application implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Job job;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Employee employee;

    @Override
    public String toString() {
        return "Application{" +
                "aid=" + aid +
                ", job=" + job +
                ", employee=" + employee +
                '}';
    }
}
