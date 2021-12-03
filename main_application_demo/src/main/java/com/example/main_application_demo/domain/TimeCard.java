package com.example.main_application_demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TimeCard {
    String user;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    LocalDateTime localDateTime;
}
