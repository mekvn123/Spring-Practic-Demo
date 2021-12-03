package com.example.figen_client.application;

import com.example.figen_client.domain.TimeCard;
import org.springframework.stereotype.Service;

@Service
public class TimeCardService {
    public void showTime(TimeCard timeCard) {
        System.out.println(timeCard);
    }
}
