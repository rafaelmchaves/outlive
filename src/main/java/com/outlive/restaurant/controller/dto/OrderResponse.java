package com.outlive.restaurant.controller.dto;

import com.outlive.restaurant.dto.OrderStatus;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
public class OrderResponse {

    private String id;
    private BigDecimal totalValue;
    private OrderStatus status;
    private BigDecimal freightValue;
    private LocalDateTime date;
    private String sellerName;


}
