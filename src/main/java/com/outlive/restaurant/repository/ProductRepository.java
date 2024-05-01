package com.outlive.restaurant.repository;

import com.outlive.restaurant.repository.entity.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    List<ProductEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);

    List<ProductEntity> findBySellerId(UUID sellerId, Pageable pageable);
}
