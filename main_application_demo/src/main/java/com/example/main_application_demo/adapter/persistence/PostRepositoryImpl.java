package com.example.main_application_demo.adapter.persistence;

import com.example.main_application_demo.domain.Post;
import com.example.main_application_demo.domain.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostMapper postMapper;

    @Override
    public List<Post> findByUserId(String id) {
        return null;
    }

    @Override
    public void savePosts(List<Post> posts) {

    }
}
