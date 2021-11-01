package com.example.main_application_demo.adapter.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main_application_demo")
public class UserInfoController {
    @GetMapping("/hello")

    public String getHello() {
        return "this is a hello test!";
    }
}
