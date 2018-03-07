package com.codecool.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
public class ComicsServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(ComicsServiceApplication.class, args);

    }

}
