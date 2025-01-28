package com.example.demo.student;

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
    }

    public void deleteStudent(Long studentId) {
        boolean exists =  studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student "+ studentId+ " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String studentName, String studentEmail) {

        Student student = studentRepository.findStudentById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist"));

        if (studentName != null && !studentName.isEmpty() && !studentName.equals(student.getName())) {
            student.setName(studentName);
        }
        if (studentEmail != null && !studentEmail.isEmpty() && !studentEmail.equals(student.getEmail())) {
            student.setEmail(studentEmail);
        }
    }
}
