package com.chandan.student.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.student.dto.request.StudentRequestDTO;
import com.chandan.student.dto.response.StudentResponseDTO;
import com.chandan.student.service.StudentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // create
    @PostMapping
    public ResponseEntity<StudentResponseDTO> addStudent(@Valid @RequestBody StudentRequestDTO requestDTO) {
        StudentResponseDTO responseDTO = studentService.createStudent(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // findall

    // find by id

    // udpate

    // delete
}
