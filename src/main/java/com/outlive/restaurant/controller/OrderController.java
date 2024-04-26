package com.outlive.restaurant.controller;

import com.outlive.restaurant.controller.dto.OrderRequest;
import com.outlive.restaurant.controller.dto.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    public ResponseEntity<OrderResponse> create(@RequestBody OrderRequest orderRequest) {


    }
}
