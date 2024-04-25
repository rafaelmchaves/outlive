package com.outlive.restaurant.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressRequest {

    private String cep;
    private String address;
    private String city;
    private String state;
    private String userId;

}
