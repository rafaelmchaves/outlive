package com.outlive.restaurant.controller.dto;

import com.outlive.restaurant.dto.UserStatus;
import com.outlive.restaurant.dto.UserType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class UserRequest {

    private String firstName;
    private String lastName;
    private String password;
    private UserStatus status;
    private UserType type;
    private SellerRequest seller;
    private CustomerRequest customer;
    private String phone;
    private String email;

}
