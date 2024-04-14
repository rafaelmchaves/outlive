package com.outlive.restaurant.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductSearchDto {

    private String name;
    private String sellerId;
}
