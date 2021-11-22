package com.example.oauth2_service.application;

import com.example.oauth2_service.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private List<User> userList;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        userList = new ArrayList<>();
        userList.add(new User(1L, "admin", password, 1, Arrays.asList("ADMIN")));
        userList.add(new User(2L, "user", password, 1, Arrays.asList("USER")));
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> findUserList = userList.stream().filter(item -> item.getUsername().equals(username)).collect(Collectors.toList());
        if (findUserList.isEmpty()) {
            throw new UsernameNotFoundException("user not find");
        }
        UserPrincipal userPrincipal = new UserPrincipal(findUserList.get(0));
        if (!userPrincipal.isEnabled()) {
            throw new DisabledException("1");
        } else if (!userPrincipal.isAccountNonLocked()) {
            throw new LockedException("2");
        } else if (!userPrincipal.isAccountNonExpired()) {
            throw new AccountExpiredException("3");
        } else if (!userPrincipal.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("4");
        }
        return userPrincipal;
    }
}
