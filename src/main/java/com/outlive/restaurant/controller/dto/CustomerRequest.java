package com.outlive.restaurant.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CustomerRequest {
    private String birthDate;
}
