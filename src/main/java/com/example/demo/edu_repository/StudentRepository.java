package com.example.demo.edu_repository;

import com.example.demo.edu_class.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    //@Query("SELECT S FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    Optional<Student> findStudentById(Long id);
}
