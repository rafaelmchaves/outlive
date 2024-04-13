package com.outlive.restaurant.controller.dto;

import com.outlive.restaurant.dto.UserStatus;
import com.outlive.restaurant.dto.UserType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private String id;
    private String firstName;
    private String lastName;
    private UserStatus status;
    private UserType type;

}
