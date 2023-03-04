package com.mag.studycase;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@RequiredArgsConstructor
@SpringBootApplication
@EnableScheduling
public class StudycaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudycaseApplication.class, args);
    }


}


