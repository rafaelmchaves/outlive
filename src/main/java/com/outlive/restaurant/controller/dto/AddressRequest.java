package com.outlive.restaurant.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressRequest {

    @NotEmpty
    private String cep;

    @NotEmpty
    private String address;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    @NotEmpty
    private String userId;

}
