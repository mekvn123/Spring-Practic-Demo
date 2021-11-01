package com.example.main_application_demo.repository.mapper;

import com.example.main_application_demo.IntegrationTest;
import com.example.main_application_demo.adapter.persistence.PostMapper;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PostMapperTest extends IntegrationTest {
    private final PostMapper postMapper;

    public PostMapperTest(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Test
    void should_save_posts_success(){

    }
}
