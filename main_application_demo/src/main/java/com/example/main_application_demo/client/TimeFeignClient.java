package com.example.main_application_demo.client;

import com.example.main_application_demo.domain.TimeCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "timeCard", url = "localhost:8082")
public interface TimeFeignClient {
    @PostMapping("/TimeCardNow")
    void printTimeCard(@RequestBody TimeCard timeCard);
}
