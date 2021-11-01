package com.example.main_application_demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
public class UserInfo extends User {
    @Getter
    @Setter
    private List<Post> posts;

    public UserInfo(final String userId, final String userName, final String userPassword, final String userEmail,
                    final List<Post> posts) {
        super(userId, userName, userPassword, userEmail);
        this.setPosts(posts);
    }
}
