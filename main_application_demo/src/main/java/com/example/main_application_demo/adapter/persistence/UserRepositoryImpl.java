package com.example.main_application_demo.adapter.persistence;

import com.example.main_application_demo.domain.User;
import com.example.main_application_demo.domain.UserInfo;
import com.example.main_application_demo.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserMapper userMapper;
    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public UserInfo findUserPostById(String id) {
        return null;
    }

    @Override
    public void saveUsers(List<User> users) {

    }

    @Override
    public void saveUsersAsync(List<User> collect) {

    }


}
