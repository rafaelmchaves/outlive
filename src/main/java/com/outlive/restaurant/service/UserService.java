package com.outlive.restaurant.service;

import com.outlive.restaurant.controller.dto.UserRequest;
import com.outlive.restaurant.controller.dto.UserResponse;
import com.outlive.restaurant.mapper.UserMapper;
import com.outlive.restaurant.repository.UserEntity;
import com.outlive.restaurant.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    private final UserMapper userMapper;

    public UserResponse create(UserRequest userRequest) {

        final var user = UserEntity.builder().firstName(userRequest.getFirstName()).lastName(userRequest.getLastName())
                .birthDate(userRequest.getBirthDate()).password(userRequest.getPassword())
                .creation(LocalDateTime.now())
                .build();

        final var persistedUser = this.repository.save(user);

        return userMapper.convert(persistedUser);
    }
}
