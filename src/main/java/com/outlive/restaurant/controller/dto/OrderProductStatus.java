package com.outlive.restaurant.controller.dto;

import com.outlive.restaurant.dto.OrderStatus;

import java.math.BigDecimal;

public class OrderProductStatus {

    private String orderId;
    private OrderStatus status;
    private String productName;
    private BigDecimal value;
}
