package com.outlive.restaurant.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Setter
@Builder
@Getter
@Entity
@Table(name = "order_product")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class OrderProductEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @JoinColumn(name = "order_id")
    @ManyToOne
    private OrderEntity order;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private OrderEntity product;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "status")
    private String status;

}
