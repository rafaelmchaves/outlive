package com.outlive.restaurant.controller;

import com.outlive.restaurant.controller.dto.FreightRequest;
import com.outlive.restaurant.controller.dto.FreightResponse;
import com.outlive.restaurant.repository.entity.FreightEntity;
import com.outlive.restaurant.service.FreightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class FreightController {

    private final FreightService freightService;

    @PutMapping("/freights")
    ResponseEntity<Void> updateFreight(@RequestBody FreightRequest freightRequest) {
        freightService.updateFreight(freightRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/freights")
    ResponseEntity<FreightResponse> getFreight(@RequestParam String cep, @RequestParam String city, @RequestParam String sellerId) {
        final var freight = freightService.getFreight(cep, city, sellerId);
        return ResponseEntity.ok(getBuild(freight.orElse(new FreightEntity())));
    }

    private static FreightResponse getBuild(FreightEntity freight) {
        return FreightResponse.builder().deliveryEstimate(freight.getDeliveryEstimate())
                .price(freight.getPrice()).build();
    }
}
