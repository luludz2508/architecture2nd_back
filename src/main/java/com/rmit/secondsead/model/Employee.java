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
public class Employee implements Serializable {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eid;
    @Column
    private String name;
    @Column
    private String gender;
    @Column
    private String phone;

    @Column
    private String pin;

    @Column
    private int age;

    @Column
    private String address;

    @Column
    private String category; // career specialization

    @Column
    private String qualification; // diploma/certificate/degree

    @Column
    private int experience; // Years of experience

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                 ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", pin='" + pin + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", category='" + category + '\'' +
                ", qualification='" + qualification + '\'' +
                ", experience=" + experience +
                '}';
    }
}
