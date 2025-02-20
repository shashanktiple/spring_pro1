package com.example.demo.edu_controller;

import com.example.demo.edu_class.Student;
import com.example.demo.edu_service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService =  studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping (path = "{studentId}/{studentName}/{studentEmail}")
    public void updateStudent(@PathVariable("studentId")Long studentId,@PathVariable("studentName") String studentName, @PathVariable("studentEmail") String studentEmail) {
        studentService.updateStudent(studentId, studentName,studentEmail);
    }
}






