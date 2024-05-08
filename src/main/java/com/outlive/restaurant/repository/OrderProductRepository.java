package com.outlive.restaurant.repository;

import com.outlive.restaurant.repository.entity.OrderProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProductEntity, UUID> {

    List<OrderProductEntity> findByOrderId(UUID orderId);
}
