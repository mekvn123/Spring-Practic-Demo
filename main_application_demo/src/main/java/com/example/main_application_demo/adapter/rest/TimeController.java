package com.example.main_application_demo.adapter.rest;

import com.example.main_application_demo.application.TimeCardService;
import com.example.main_application_demo.domain.TimeCard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main_application_demo")
public class TimeController {
    private final TimeCardService timeCardService;

    public TimeController(TimeCardService timeCardService) {
        this.timeCardService = timeCardService;
    }

    @PostMapping("/time")
    public TimeCard postTime() {
        return timeCardService.creatNow();
    }

    @GetMapping("/timeNow")
    public void timeShow() {
        timeCardService.showTimeNow();
    }

}
