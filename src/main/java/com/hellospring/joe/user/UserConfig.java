package com.hellospring.joe.user;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository repository) {
        return args -> {
            User ali = new User(
                    "Ali",
                    "ali@gmail.com",
                    LocalDate.of(1989,Month.FEBRUARY,5)
                    );
            User peter = new User(
                    "Peter",
                    "peter@gmail.com",
                    LocalDate.of(1989,Month.MAY,5)
                    );

                    repository.saveAll(List.of(ali,peter));
        };
    }
}
