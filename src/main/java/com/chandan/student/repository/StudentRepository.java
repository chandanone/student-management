package com.chandan.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandan.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
