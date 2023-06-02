package com.example.nplusone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class NPlusOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(NPlusOneApplication.class, args);
    }

}
