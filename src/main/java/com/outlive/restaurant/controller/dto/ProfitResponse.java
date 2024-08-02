package com.outlive.restaurant.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Builder
@Setter
public class ProfitResponse {

    private Integer totalSold;
    private BigDecimal totalValueSold;
    private BigDecimal costTotal;
    private BigDecimal profit;
}
