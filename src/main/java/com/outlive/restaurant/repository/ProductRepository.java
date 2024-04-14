package com.outlive.restaurant.repository;

import com.outlive.restaurant.repository.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<ProductEntity, UUID> {

    List<ProductEntity> findByNameContainingIgnoreCase(String name);
}
