package com.example.main_application_demo.repository;

import com.example.main_application_demo.adapter.persistence.UserMapper;
import com.example.main_application_demo.adapter.persistence.UserRepositoryImpl;
import com.example.main_application_demo.domain.User;
import com.example.main_application_demo.unit.FileUtils;
import com.example.main_application_demo.unit.JsonHelper;
import com.example.main_application_demo.unit.UnitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserRepositoryImplTest extends UnitTest {
    @Mock
    UserMapper userMapper;

    @InjectMocks
    private UserRepositoryImpl userRepository;

    private User user;

    @BeforeAll
    void setAll() {
        String jsonFileName = "testUser.json";
        user = JsonHelper.deserialization(FileUtils.loadTestSuiteResource(jsonFileName), User.class);
    }

    @Test
    public void should_get_user_info_success() {
        //given
        doReturn(Optional.of(user)).when(this.userMapper).findUserById(user.getUserId());

        // when
        User findUser = userRepository.findById(user.getUserId());

        // then
        Assertions.assertEquals(user, findUser);
    }
}
