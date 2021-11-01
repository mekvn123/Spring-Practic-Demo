package com.example.main_application_demo.adapter.persistence;

import com.example.main_application_demo.domain.User;
import com.example.main_application_demo.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<User> findUserById(@Param("userId") String id);

    void insertUser(@Param("param") User user);

    void insertUsers(@Param("param") List<User> users);

    void updateUser(@Param("param") User user);

    // 级联操作-查询
    Optional<UserInfo> findUserPostById(@Param("userId") String id);
}
