package com.example.main_application_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class MainApplicationDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplicationDemoApplication.class, args);
    }

}
