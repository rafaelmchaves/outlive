package com.outlive.restaurant.controller.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class UserRequest {

    private String firstName;
    private String lastName;
    private String birthDate;
    private String password;

}
