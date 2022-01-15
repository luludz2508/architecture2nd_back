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
public class Employer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eid;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String pin;

    @Column
    private String address;

    @Override
    public String toString() {
        return "Employer{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", pin='" + pin + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
