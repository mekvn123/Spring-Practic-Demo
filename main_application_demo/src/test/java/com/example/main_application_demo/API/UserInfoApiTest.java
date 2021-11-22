package com.example.main_application_demo.API;

import com.example.main_application_demo.adapter.persistence.UserMapper;
import com.example.main_application_demo.application.dto.UserDto;
import com.example.main_application_demo.domain.User;
import com.example.main_application_demo.unit.FileUtils;
import com.example.main_application_demo.unit.IntegrationTest;
import com.example.main_application_demo.unit.JsonHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserInfoApiTest extends IntegrationTest {

    private final TestRestTemplate testRestTemplate;
    private final UserMapper userMapper;
    private User user;

    @Autowired
    public UserInfoApiTest(TestRestTemplate testRestTemplate, UserMapper userMapper) {
        this.testRestTemplate = testRestTemplate;
        this.userMapper = userMapper;
    }

    @BeforeEach
    void setUserInfo() {
        String jsonFileName = "testUser.json";
        user = JsonHelper.deserialization(FileUtils.loadTestSuiteResource(jsonFileName), User.class);

    }

    @Test
    void should_get_hello_by_testRestTemplate() {
        ResponseEntity<String> forEntity = testRestTemplate.getForEntity("/main_application_demo/hello", String.class);
        Assertions.assertEquals(HttpStatus.OK, forEntity.getStatusCode());
        System.out.println(forEntity.getBody());
    }

    @Test
    void should_save_user_success_with_testRestTemplate() {
        testRestTemplate.put("/main_application_demo/user", user);
    }

    @Test
    void should_get_user_success_with_testRestTemplate() {
        userMapper.insertUser(user);

        ResponseEntity<UserDto> forEntity = testRestTemplate.getForEntity(String.format("/main_application_demo/user/%s", user.getUserId()), UserDto.class);
        Assertions.assertEquals(HttpStatus.OK, forEntity.getStatusCode());
        System.out.println(forEntity.getBody());
    }

    @Test
    void should_get_user_success_with_mock_mvc() {

        userMapper.insertUser(user);
        given()
                .when()
                .get(String.format("/main_application_demo/user/%s", user.getUserId()))
                .then()
                .statusCode(200);
    }

    @Test
    void test_translate_with_mock_mvc() {
        given()
                .when()
                .get(String.format("/main_application_demo/user/translate/%s", user.getUserId()))
                .then()
                .statusCode(200);
    }
}
