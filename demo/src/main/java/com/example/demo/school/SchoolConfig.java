package com.example.demo.school;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class SchoolConfig {

    @Bean
    CommandLineRunner CLR(SchoolRepository repository) {
        return args -> {
            School mcchs = new School("MCCHS", "Chandrapur", LocalDate.of(1990, Month.MAY, 05));
            School puneuni = new School("PuneUni", "Pune", LocalDate.of(1973, Month.JANUARY, 25));

            repository.saveAll(List.of(mcchs,puneuni));
        };
    }
}


