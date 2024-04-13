package com.outlive.restaurant.controller.dto;

import com.outlive.restaurant.dto.ProductStatus;
import com.outlive.restaurant.dto.ProductType;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
public class ProductResponse {

    private String id;
    private String name;
    private String description;
    private ProductType type;
    private BigDecimal price;
    private BigDecimal quantity;
    private ProductStatus status;

}
