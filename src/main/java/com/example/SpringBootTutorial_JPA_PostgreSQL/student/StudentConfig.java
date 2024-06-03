package com.example.SpringBootTutorial_JPA_PostgreSQL.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
           Student magarate = new Student(
                    "Magarate Kingston",
                   LocalDate.of(2000, Month.JANUARY,5),
                   "Magarate.Kingston@gmail.com"
            );
            Student alex = new Student(
                    "Alex Sunchester",

                    LocalDate.of(1998, Month.JANUARY,5) ,
                    "Alex.Sunchester@gmail.com"//calculte from dob to current date
            );
            repository.saveAll(
                    List.of(magarate, alex
                    )
            );
        };
    }
}
