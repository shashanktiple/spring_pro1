package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository) {
//        return args -> {
//            Student shashank = new Student("Shashank", LocalDate.of(1993, Month.MAY, 07), "shanky@gmail.com"
//            );
//
//            Student tiple = new Student("tiple", LocalDate.of(2000, Month.JANUARY, 01), "tiple@gmail.com"
//            );
//
//            repository.saveAll(
//                    List.of(shashank, tiple)
//            );
//        };
//    }
}
