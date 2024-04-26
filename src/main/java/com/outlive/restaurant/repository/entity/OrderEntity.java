package com.outlive.restaurant.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Builder
@Getter
@Entity
@Table(name = "orders")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "total_value")
    private BigDecimal totalValue;

    @Column(name = "items_amount")
    private Integer itemsAmount;

    @Column(name = "freight_value")
    private BigDecimal freightValue;

    @Column(name = "payment_method")
    private String paymentMethod;

    private String status;

    @JoinColumn(name = "address_id")
    @ManyToOne
    private AddressEntity addressEntity;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity user;

    @Column(name = "creation_on")
    private LocalDateTime creation;

}
