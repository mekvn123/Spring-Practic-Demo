package com.example.main_application_demo.application;

import com.example.main_application_demo.client.EncodeFeignClient;
import com.example.main_application_demo.domain.User;
import com.example.main_application_demo.domain.UserRepository;
import com.example.main_application_demo.exception.UserNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EncodeFeignClient encodeFeignClient;


    public User getUser(String id) {
        User userFound;
        try {
            userFound = userRepository.findById(id);
        } catch (RuntimeException ex) {
            throw new UserNotExistException(ex.getMessage());
        }
        return userFound;
    }

    @Transactional
    public void createUser(User user) {
        user.setUserPassword(encodeFeignClient.getEncode("Base64", user.getUserPassword()));
        try {
            userRepository.findById(user.getUserId());
        } catch (Exception ex) {
            userRepository.saveUser(user);
        }
    }
}
