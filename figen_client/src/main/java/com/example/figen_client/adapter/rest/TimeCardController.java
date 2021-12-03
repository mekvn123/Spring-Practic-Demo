package com.example.figen_client.adapter.rest;

import com.example.figen_client.application.TimeCardService;
import com.example.figen_client.domain.TimeCard;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeCardController {
    private final TimeCardService timeCardService;

    public TimeCardController(TimeCardService timeCardService) {
        this.timeCardService = timeCardService;
    }

    @PostMapping("/TimeCardNow")
    public void printTimeCard(@RequestBody TimeCard timeCard){
        timeCardService.showTime(timeCard);
    }
}
