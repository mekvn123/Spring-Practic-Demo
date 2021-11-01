package com.example.main_application_demo.domain;

import java.util.List;

public interface PostRepository {
    List<Post> findByUserId(String id);

    void savePosts(List<Post> posts);
}
