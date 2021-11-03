package com.example.main_application_demo.adapter.rest;

import com.example.main_application_demo.application.UserService;
import com.example.main_application_demo.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main_application_demo")
@RequiredArgsConstructor
public class UserInfoController {
    private final UserService userService;

    @GetMapping("/hello")
    public String getHello() {
        return "this is a hello test!";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @PutMapping("/user")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("/user/translate/{id}")
    public void testTranslate(@PathVariable String id) {
        userService.translate(id);
    }
}
