package com.outlive.restaurant.controller.dto;

import com.outlive.restaurant.dto.OrderStatus;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class OrderProductStatus {

    private String orderId;
    private OrderStatus status;
    private String productName;
    private BigDecimal value;
}
