package com.example.demo.edu_repository;

import com.example.demo.edu_class.School;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface SchoolRepository extends JpaRepository<School, Integer> {


    Optional<School> findSchoolByName(String name);


}
