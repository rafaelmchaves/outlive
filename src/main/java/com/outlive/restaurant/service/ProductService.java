package com.outlive.restaurant.service;

import com.outlive.restaurant.controller.dto.ProductRequest;
import com.outlive.restaurant.controller.dto.ProductResponse;
import com.outlive.restaurant.dto.ProductSearchDto;
import com.outlive.restaurant.dto.ProductStatus;
import com.outlive.restaurant.mapper.ProductMapper;
import com.outlive.restaurant.repository.ProductEntity;
import com.outlive.restaurant.repository.ProductRepository;
import com.outlive.restaurant.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository repository;

    private final SellerRepository sellerRepository;

    public ProductResponse create(ProductRequest productRequest) {

        final var seller = this.sellerRepository.findById(UUID.fromString(productRequest.getSellerId())).orElseThrow(() ->
                new RuntimeException("Seller not found"));

        final var entity = productMapper.convert(productRequest);
        entity.setCreation(LocalDateTime.now());
        entity.setStatus(ProductStatus.AVAILABLE);
        entity.setSeller(seller);

        final var persistedProduct = repository.save(entity);
        return productMapper.convert(persistedProduct);
    }

    public List<ProductResponse> searchProducts(ProductSearchDto productSearchDto) {

        List<ProductEntity> productEntities = null;
        if (productSearchDto.getName() != null) {
            productEntities = repository.findByNameContainingIgnoreCase(productSearchDto.getName());
        }

        return productMapper.convert(productEntities);
    }
}
