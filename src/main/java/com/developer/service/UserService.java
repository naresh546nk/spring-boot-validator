package com.developer.service;

import com.developer.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public List<User> getUsers() {
        return List.of(
                User.builder()
                .id(1)
                .name("Naresh Kumar")
                .email("naresh546.nk@gmail.com")
                .age(28)
                .build(),
                User.builder()
                        .id(2)
                        .name("Ramesh Kumar")
                        .email("ramesh.nk@gmail.com")
                        .age(27)
                        .build(),
                User.builder()
                        .id(3)
                        .name("Abinash Kumar")
                        .email("abinash@gmail.com")
                        .age(25)
                        .build()
        );
    }

    public User saveUser(User user) {
        return  user;
    }
}
