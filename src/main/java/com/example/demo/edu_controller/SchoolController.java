package com.example.demo.edu_controller;


import com.example.demo.edu_class.School;
import com.example.demo.edu_service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path ="api/v2/school" )
public class SchoolController {
    private final SchoolService schoolService;


    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;

    }

    @GetMapping
    public List<School> getSchools() {
        return schoolService.getSchools();
    }

    @PostMapping
    public void registerSchool(@RequestBody School school) {
        schoolService.addSchool(school);
    }

    @DeleteMapping(path = "{schoolName}")
    public void deleteSchool(@PathVariable("schoolName") String schoolName) {
        schoolService.deleteSchoolByName(schoolName);
    }

    @PutMapping(path= "{schoolName}/{schoolAddress}/{schoolFounded}")
    public void updateSchool(@PathVariable("schoolName") String schoolName,
                             @PathVariable("schoolAddress") String schoolAddress,
                             //@PathVariable("schoolFounded") LocalDate schoolFounded)
                             @PathVariable("schoolFounded")
                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate schoolFounded){

        schoolService.updateSchool(schoolName, schoolAddress, schoolFounded);
    }

}
