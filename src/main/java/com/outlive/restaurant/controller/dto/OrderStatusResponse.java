package com.outlive.restaurant.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class OrderStatusResponse {

    private List<OrderProductStatus> orderProductList;
}
