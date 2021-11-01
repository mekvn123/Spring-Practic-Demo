package com.example.main_application_demo.adapter.persistence;

import com.example.main_application_demo.domain.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> findByUserId(@Param("userId") String id);

    void insertPosts(@Param("list") List<Post> posts);
}
