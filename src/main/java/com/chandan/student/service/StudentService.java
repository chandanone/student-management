package com.chandan.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandan.student.dto.request.StudentRequestDTO;
import com.chandan.student.dto.response.StudentResponseDTO;
import com.chandan.student.entity.Student;
import com.chandan.student.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // create
    public StudentResponseDTO createStudent(StudentRequestDTO requestDTO) {

        // 1. Map Request DTO -> Entity
        Student student = new Student(
                requestDTO.course(),
                requestDTO.name(),
                requestDTO.email(),
                requestDTO.age());
        // 2. Save Entity to Database
        Student savedStudent = studentRepository.save(student);

        // 3. Map Saved Entity -> Response DTO (Includes the generated ID!)

        return new StudentResponseDTO(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getEmail(),
                savedStudent.getCourse(),
                savedStudent.getAge());
    }

    // get all
    public List<StudentResponseDTO> getAllStudents() {
        // 1. Fetch all Student entities from the database
        List<Student> students = studentRepository.findAll();

        // 2. Convert the list of Entities into a list of Response DTOs
        return students.stream()
                .map(student -> new StudentResponseDTO(
                        student.getId(),
                        student.getName(),
                        student.getEmail(),
                        student.getCourse(),
                        student.getAge()))
                .toList(); // Collects the stream back into a List
    }

    // get by id
    public Optional<StudentResponseDTO> getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(student -> new StudentResponseDTO(
                        student.getId(),
                        student.getName(),
                        student.getEmail(),
                        student.getCourse(),
                        student.getAge()));
    }

    // update
    public Student editStudent(Long id, Student studentDetails) {
        // find
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        // setter
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setAge(student.getAge());
        student.setCourse(student.getCourse());

        return studentRepository.save(student);

    }

    // delete
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student npt found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
}
