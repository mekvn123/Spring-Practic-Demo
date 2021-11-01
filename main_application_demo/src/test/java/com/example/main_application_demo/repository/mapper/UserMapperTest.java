package com.example.main_application_demo.repository.mapper;

import com.alibaba.fastjson.JSONObject;
import com.example.main_application_demo.IntegrationTest;
import com.example.main_application_demo.adapter.persistence.PostMapper;
import com.example.main_application_demo.adapter.persistence.UserMapper;
import com.example.main_application_demo.domain.Post;
import com.example.main_application_demo.domain.User;
import com.example.main_application_demo.domain.UserInfo;
import com.example.main_application_demo.unit.FileUtils;
import com.example.main_application_demo.unit.JsonHelper;
import com.alibaba.fastjson.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserMapperTest extends IntegrationTest {
    private final UserMapper userMapper;
    private final PostMapper postMapper;

    @Autowired
    public UserMapperTest(UserMapper userMapper, PostMapper postMapper) {
        this.userMapper = userMapper;
        this.postMapper = postMapper;
    }

    @Nested
    @DisplayName("基础测试")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class BaseTest {
        private User testUser;


        @BeforeAll
        void setTestUser() {
            String jsonFileName = "testUser.json";
            testUser = JsonHelper.deserialization(FileUtils.loadTestSuiteResource(jsonFileName), User.class);
           }

        @Test
        @DisplayName("base save test")
        void should_get_user_success_by_id() {
            // given
            userMapper.insertUser(testUser);

            // when
            Optional<User> findUser = userMapper.findUserById("ID00001");

            // then
            Assertions.assertTrue(findUser.isPresent());
            Assertions.assertEquals(testUser, findUser.get());
        }

        @Test
        @DisplayName("base update test")
        void should_update_user_success() {
            // given
            userMapper.insertUser(testUser);
            User updateUser = testUser;
            updateUser.setUserName("updateName");

            // when
            userMapper.updateUser(updateUser);

            // then
            Assertions.assertEquals(updateUser.getUserName(),
                    userMapper.findUserById(updateUser.getUserId()).get().getUserName());
        }
    }

    @Nested
    @DisplayName("级联测试")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class CascadeTest {
        private User user;
        private UserInfo testUserInfo;

        @BeforeAll
        void setUserInfo() {
            String jsonFileName = "testUser.json";
            user = JsonHelper.deserialization(FileUtils.loadTestSuiteResource(jsonFileName), User.class);
            String jsonFileUserInfo = "testUserinfo.json";
            testUserInfo = JsonHelper.deserialization(FileUtils.loadTestSuiteResource(jsonFileUserInfo), UserInfo.class);

        }

        @Test
        @DisplayName("cascade select test")
        void should_insert_userInfo_success_by_cascade_way() {
            // given
            userMapper.insertUser(user);
            String jsonFileName = "posts.json";
            JSONArray array = JSONArray.parseArray(FileUtils.loadTestSuiteResource(jsonFileName));
            List<Post> postList = JSONObject.parseArray(array.toJSONString(), Post.class);
            postMapper.insertPosts(postList);

            // when
            Optional<UserInfo> findUserInfo = userMapper.findUserPostById(testUserInfo.getUserId());

            // then
            Assertions.assertTrue(findUserInfo.isPresent());
        }
    }
}
