package com.outlive.restaurant.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressResponse {

    private String city;
    private String state;
    private String zipCode;
    private String address;
}
