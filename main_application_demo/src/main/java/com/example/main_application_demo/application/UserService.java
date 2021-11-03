package com.example.main_application_demo.application;

import com.example.main_application_demo.client.EncodeFeignClient;
import com.example.main_application_demo.domain.User;
import com.example.main_application_demo.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EncodeFeignClient encodeFeignClient;


    public User getUser(String id) {
        return userRepository.findById(id);
    }

    @Transactional()
    public void translate(String id) {
        try {
            userRepository.findById(id);
        } catch (RuntimeException ex) {
            userRepository.saveUser(User.builder().userId(id).userName("translate").build());
        }
    }

    public void createUser(User user) {
        user.setUserPassword(encodeFeignClient.getEncode(user.getUserPassword()));
        userRepository.saveUser(user);
    }
}
