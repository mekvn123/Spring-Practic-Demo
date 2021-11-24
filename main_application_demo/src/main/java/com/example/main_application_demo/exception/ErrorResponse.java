package com.example.main_application_demo.exception;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ErrorResponse {
    Integer status;
    String error;
    String message;
}
