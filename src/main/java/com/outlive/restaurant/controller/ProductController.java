package com.outlive.restaurant.controller;

import com.outlive.restaurant.controller.dto.ProductRequest;
import com.outlive.restaurant.controller.dto.ProductResponse;
import com.outlive.restaurant.dto.ProductSearchDto;
import com.outlive.restaurant.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    ResponseEntity<ProductResponse> create(@RequestBody ProductRequest productRequest) {
        final var productResponse = productService.create(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @GetMapping("/products")
    ResponseEntity<List<ProductResponse>> getAllByQuery(@RequestParam String name) {
        final var result = productService.searchProducts(ProductSearchDto.builder().name(name).build());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/sellers/{sellerId}/products")
    ResponseEntity<List<ProductResponse>> getAllBySeller(@PathVariable String sellerId) {
        final var result = productService.searchProducts(ProductSearchDto.builder().sellerId(sellerId).build());
        return ResponseEntity.ok(result);
    }
}
