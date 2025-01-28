package com.example.demo.school;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface SchoolRepository extends JpaRepository<School, Integer> {


    Optional<School> findSchoolByName(String name);


}
