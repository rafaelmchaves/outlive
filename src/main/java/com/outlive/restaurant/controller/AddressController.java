package com.outlive.restaurant.controller;

import com.outlive.restaurant.controller.dto.AddressRequest;
import com.outlive.restaurant.controller.dto.AddressResponse;
import com.outlive.restaurant.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/addresses")
    public ResponseEntity<AddressResponse> createAddress(@RequestBody AddressRequest addressRequest) {
       final var response = addressService.create(addressRequest);
       return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
