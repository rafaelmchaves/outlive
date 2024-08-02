package com.outlive.restaurant.repository;

import com.outlive.restaurant.repository.entity.OrderEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    List<OrderEntity> findByCustomerId(UUID customerId, Pageable pageable);
    @Query(value = "from OrderEntity t where creation BETWEEN :startDate AND :endDate")
    List<OrderEntity> findAllBetweenDate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
