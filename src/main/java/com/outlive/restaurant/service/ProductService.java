package com.outlive.restaurant.service;

import com.outlive.restaurant.controller.dto.ProductRequest;
import com.outlive.restaurant.controller.dto.ProductResponse;
import com.outlive.restaurant.dto.ProductStatus;
import com.outlive.restaurant.dto.UserType;
import com.outlive.restaurant.mapper.ProductMapper;
import com.outlive.restaurant.repository.ProductRepository;
import com.outlive.restaurant.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository repository;

    private final UserRepository userRepository;

    public ProductResponse create(ProductRequest productRequest) {

        final var user = this.userRepository.findById(UUID.fromString(productRequest.getSellerId())).orElseThrow(() ->
                new RuntimeException("User not found"));

        if (!user.getType().equals(UserType.SELLER)) {
            throw new RuntimeException("Only sellers are able to sell products");
        }

        final var entity = productMapper.convert(productRequest);
        entity.setCreation(LocalDateTime.now());
        entity.setStatus(ProductStatus.AVAILABLE);
        entity.setUser(user);

        final var persistedProduct = repository.save(entity);
        return productMapper.convert(persistedProduct);
    }
}
