package com.ramesh.javaguides.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(name = "employee_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "employee_sequence")
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;


}
