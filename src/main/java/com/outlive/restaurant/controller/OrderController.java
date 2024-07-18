package com.outlive.restaurant.controller;

import com.outlive.restaurant.controller.dto.*;
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

    @PatchMapping("/orders/{id}/status")
    public ResponseEntity<OrderStatusResponse> updateStatus(@PathVariable String id, @RequestBody OrderStatusRequest orderStatusRequest) {
        orderService.updateStatus(orderStatusRequest.getOrderStatus(), id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/orders/{id}/details")
    public ResponseEntity<List<OrderProductStatus>>getOrderDetails(@PathVariable String id) {
        final var result = orderService.getOrdersDetails(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/customers/{customerId}/orders")
    public ResponseEntity<List<OrderResponse>> getOrders(@PathVariable String customerId, @RequestParam int page, @RequestParam int size) {
        final var orders = this.orderService.getOrders(customerId, page, size);

        final var orderResponseList = orders.stream().map(orderEntity -> OrderResponse.builder().id(orderEntity.getId().toString())
                .totalValue(orderEntity.getTotalValue()).freightValue(orderEntity.getFreightValue()).status(orderEntity.getStatus())
                .date(orderEntity.getCreation())
                .build()).toList();
        return ResponseEntity.ok(orderResponseList);
    }
}
