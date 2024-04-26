package com.outlive.restaurant.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class OrderProductRequest {

    private String productId;
    private Integer amount;
    private BigDecimal price;

}
