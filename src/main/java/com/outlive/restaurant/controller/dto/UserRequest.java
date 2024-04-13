package com.outlive.restaurant.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserRequest {

    private String firstName;
    private String lastName;
    private String birthDate;
    private String password;

}
