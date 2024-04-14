package com.outlive.restaurant.controller.dto;

import com.outlive.restaurant.dto.UserStatus;
import com.outlive.restaurant.dto.UserType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SellerResponse {

    private String id;
    private UserStatus status;
    private UserType type;
    private String description;
    private String logo;
    private AddressResponse addressResponse;

}
