package com.outlive.restaurant.repository.entity;

import com.outlive.restaurant.dto.ProductStatus;
import com.outlive.restaurant.dto.ProductType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Builder
@Getter
@Entity
@Table(name = "products")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String description;

    private ProductType type;

    private BigDecimal price;

    private BigDecimal quantity;

    private ProductStatus status;

    @Column(name = "created_on")
    private LocalDateTime creation;

    @Column(name = "updated_on")
    private LocalDateTime update;

    @JoinColumn(name = "seller_id")
    @ManyToOne
    private SellerEntity seller;
}
