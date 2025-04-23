package com.example.demo.edu_service;

import com.example.demo.edu_class.Student;
import com.example.demo.edu_class.StudentDto;
import com.example.demo.edu_repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already in use");
        }
        studentRepository.save(student);
        System.out.println("New student added");
    }

    public void deleteStudent(Long studentId) {
        boolean exists =  studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student "+ studentId+ " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        Student student = studentRepository.findStudentById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist"));

        student.setName(name);
        student.setEmail(email);
        }

    @Transactional
    public void updateStudentDto(StudentDto dto) {

        Student student = studentRepository.findStudentById(dto.getId())
                .orElseThrow(() -> new IllegalStateException("Student " + dto.getId() + " does not exist"));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
    }
}



