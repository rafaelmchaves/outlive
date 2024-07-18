package com.outlive.restaurant.controller;

import com.outlive.restaurant.controller.dto.ProductRequest;
import com.outlive.restaurant.controller.dto.ProductResponse;
import com.outlive.restaurant.controller.dto.ProductStockRequest;
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

    @PatchMapping("/products/{id}/stock")
    public ResponseEntity<Void> updateStock(@PathVariable String id, @RequestBody ProductStockRequest productStockRequest) {
        productService.updateStock(id, productStockRequest.getAmount());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/products")
    ResponseEntity<List<ProductResponse>> getAllByQuery(@RequestParam String name, @RequestParam int page, @RequestParam int size) {
        final var result = productService.searchProducts(ProductSearchDto.builder().name(name).page(page).size(size).build());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/sellers/{sellerId}/products")
    ResponseEntity<List<ProductResponse>> getAllBySeller(@PathVariable String sellerId, @RequestParam int page, @RequestParam int size) {
        final var result = productService.searchProducts(ProductSearchDto.builder().sellerId(sellerId).page(page).size(size).build());
        return ResponseEntity.ok(result);
    }
}
