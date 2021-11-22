package com.example.figen_client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = FigenClientApplication.class, webEnvironment = RANDOM_PORT)

public class ApiTest {
    private final TestRestTemplate testRestTemplate;
    private final String source = "this is a test.";

    @Autowired
    public ApiTest(TestRestTemplate testRestTemplate) {
        this.testRestTemplate = testRestTemplate;
    }

    @Test
    void Base64_encode_should_be_success() {
        // given
        HttpHeaders headers = new HttpHeaders();
        headers.add("encode", "Base64");
        HttpEntity<String> entity = new HttpEntity<>(source, headers);

        // when
        ResponseEntity<String> forEntity = testRestTemplate.postForEntity("/encode", entity, String.class);

        // then
        Assertions.assertEquals(HttpStatus.OK, forEntity.getStatusCode());
        Assertions.assertEquals("dGhpcyBpcyBhIHRlc3Qu", forEntity.getBody());
    }

    @Test
    void JWT_encode_should_be_success() {
        // TODO add test
    }

    @Test
    void should_if_when_not_find_encode() {
        // when
        ResponseEntity<String> forEntity = testRestTemplate.postForEntity("/encode", null, String.class);

        // then
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, forEntity.getStatusCode());
    }
}
