package com.example.main_application_demo.application.dto;

import com.example.main_application_demo.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserInfoDto {
    private String userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private List<Post> posts;
}
