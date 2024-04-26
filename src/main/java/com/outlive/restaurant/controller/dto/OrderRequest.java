package com.outlive.restaurant.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class OrderRequest {

    private List<OrderProductRequest> orders;

    private String userId;

    private String addressId;

    private String paymentMethod;

}
