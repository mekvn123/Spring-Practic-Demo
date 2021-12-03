package com.example.main_application_demo.application;

import com.example.main_application_demo.client.TimeFeignClient;
import com.example.main_application_demo.domain.TimeCard;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TimeCardService {

    private final TimeFeignClient timeFeignClient;

    public TimeCardService(TimeFeignClient timeFeignClient) {
        this.timeFeignClient = timeFeignClient;
    }

    public TimeCard creatNow() {
        return new TimeCard("testUser", LocalDateTime.now());
    }

    public void showTimeNow() {
        TimeCard timeCard = creatNow();
        timeFeignClient.printTimeCard(timeCard);
    }
}
