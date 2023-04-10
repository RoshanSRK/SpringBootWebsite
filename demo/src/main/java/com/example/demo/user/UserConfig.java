package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args->{
            User mariam = new User(
                    1L,
                    "Mariam",
                    "Mariam123",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, AUGUST, 5)
            );

            User alex = new User(
                    "Alex",
                    "alex@gmail.com",
                    "Alex123",
                    LocalDate.of(2004, AUGUST, 5)
            );
            repository.saveAll(
                    List.of(mariam,alex)
            );
        };
    }
}
