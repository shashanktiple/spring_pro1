package com.example.demo.school;

import com.example.demo.student.StudentRepository;
import com.fasterxml.jackson.annotation.OptBoolean;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    private  SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    public void addSchool(School school) {
        Optional<School> schoolOptional = schoolRepository.findSchoolByName(school.getName());
        if (schoolOptional.isPresent()) {
            throw new IllegalStateException("School already exists");
        }
        schoolRepository.save(school);
    }

    public void deleteSchoolByName(String schoolName) {
        Optional<School> schoolOptional= schoolRepository.findSchoolByName(schoolName);

        if (!schoolOptional.isPresent()) {
            throw new IllegalStateException("School does not exists");
        }
        schoolRepository.delete(schoolOptional.get());
    }

    @Transactional
    public void updateSchool(String schoolName, String schoolAddress, LocalDate schoolFounded) {
        School school = schoolRepository.findSchoolByName(schoolName)
                .orElseThrow(()-> new IllegalStateException("School does not exists"));


        if (schoolAddress != null && !schoolAddress.isEmpty() && !schoolAddress.equals(school.getAddress())) {
            school.setAddress(schoolAddress);
        }

        if (schoolFounded != null && schoolFounded.getYear() != 0) {
            school.setFounded(schoolFounded);
        }
        schoolRepository.save(school);
    }
}
