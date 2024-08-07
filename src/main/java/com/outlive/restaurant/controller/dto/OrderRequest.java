package com.outlive.restaurant.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class OrderRequest {

    private List<OrderProductRequest> orders;

    private String customerId;

    private String addressId;

    private String addressText;

    private String paymentMethod;

}
