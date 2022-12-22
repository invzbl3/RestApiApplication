package com.test.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author invzbl3 on 12/15/2022
 * @project RestApiApplication
 */
@SpringBootApplication
        (scanBasePackages={"com.test.application", "com.example.application"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}