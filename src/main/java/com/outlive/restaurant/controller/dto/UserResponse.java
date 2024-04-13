package com.outlive.restaurant.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private String id;
    private String firstName;
    private String lastName;

}
