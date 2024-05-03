package com.outlive.restaurant.controller;

import com.outlive.restaurant.controller.dto.OrderRequest;
import com.outlive.restaurant.controller.dto.OrderResponse;
import com.outlive.restaurant.controller.dto.OrderStatusResponse;
import com.outlive.restaurant.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<OrderStatusResponse> create(@RequestBody OrderRequest orderRequest) {
        orderService.create(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/customers/{id}/orders-detail")
    public ResponseEntity<OrderStatusResponse>getStatus() {

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/customers/{id}/orders")
    public ResponseEntity<List<OrderResponse>> getOrders(@PathVariable String id, @RequestParam int page, @RequestParam int size) {
        final var orders = this.orderService.getOrders(id, page, size);

        final var orderResponseList = orders.stream().map(orderEntity -> OrderResponse.builder().id(orderEntity.getId().toString())
                .totalValue(orderEntity.getTotalValue()).freightValue(orderEntity.getFreightValue()).status(orderEntity.getStatus())
                .date(orderEntity.getCreation())
                .build()).toList();
        return ResponseEntity.ok(orderResponseList);
    }
}
