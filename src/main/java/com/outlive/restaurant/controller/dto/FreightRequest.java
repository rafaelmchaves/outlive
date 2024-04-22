package com.outlive.restaurant.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class FreightRequest {

    private String cep;

    private String city;

    private BigDecimal price;

    private String deliveryEstimate;

    private String sellerId;
}
