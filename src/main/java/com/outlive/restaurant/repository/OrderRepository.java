package com.outlive.restaurant.repository;

import com.outlive.restaurant.repository.entity.OrderEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    List<OrderEntity> findByCustomerId(UUID customerId, Pageable pageable);

}
