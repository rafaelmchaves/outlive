package com.outlive.restaurant.controller.dto;

import com.outlive.restaurant.dto.ProductType;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class ProductRequest {

    private String name;
    private String description;
    private ProductType type;
    private BigDecimal price;
    private BigDecimal quantity;
    private String sellerId;

}
