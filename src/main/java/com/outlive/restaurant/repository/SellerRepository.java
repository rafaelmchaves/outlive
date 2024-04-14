package com.outlive.restaurant.repository;

import com.outlive.restaurant.repository.entity.SellerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SellerRepository extends CrudRepository<SellerEntity, UUID> {
}
