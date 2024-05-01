package com.outlive.restaurant.repository.entity;

import com.outlive.restaurant.dto.OrderStatus;
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

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @JoinColumn(name = "address_id")
    @ManyToOne
    private AddressEntity address;

    @JoinColumn(name = "customer_id")
    @ManyToOne
    private CustomerEntity customer;

    @Column(name = "creation_on")
    private LocalDateTime creation;

}
