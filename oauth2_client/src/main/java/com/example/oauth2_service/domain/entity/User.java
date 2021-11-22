package com.example.oauth2_service.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String password;
    private Integer status;
    private List<String> roles;
}
