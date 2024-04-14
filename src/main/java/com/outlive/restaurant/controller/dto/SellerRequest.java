package com.outlive.restaurant.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SellerRequest {

    private String description;
    private String logo;
    private String city;
    private String state;
    private String zipCode;
    private String address;
}
