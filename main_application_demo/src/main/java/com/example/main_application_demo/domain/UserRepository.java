package com.example.main_application_demo.domain;


import java.util.List;

public interface UserRepository {
    User findById(String id);

    UserInfo findUserPostById(String id);

    void saveUsers(List<User> users);

    void saveUsersAsync(List<User> collect);


}
