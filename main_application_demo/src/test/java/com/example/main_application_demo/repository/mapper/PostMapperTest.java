package com.example.main_application_demo.repository.mapper;

import com.example.main_application_demo.unit.IntegrationTest;
import com.example.main_application_demo.adapter.persistence.PostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PostMapperTest extends IntegrationTest {
    private final PostMapper postMapper;

    @Autowired
    public PostMapperTest(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Test
    void should_save_posts_success() {
        //TODO finish test
    }
}
