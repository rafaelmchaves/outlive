package com.outlive.restaurant.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class FreightResponse {

    private String deliveryEstimate;

    private BigDecimal price;
}
