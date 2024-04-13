package com.outlive.restaurant.controller;

import com.outlive.restaurant.controller.dto.UserRequest;
import com.outlive.restaurant.controller.dto.UserResponse;
import com.outlive.restaurant.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) {
        final var userResponse = userService.create(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
}
