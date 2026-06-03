package com.chandan.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email Invalid Format")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Course is required")
    @Column(nullable = false)
    private String course;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Column(nullable = false)
    private Integer age;
}
