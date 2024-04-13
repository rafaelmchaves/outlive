package com.outlive.restaurant.repository;

import com.outlive.restaurant.dto.ProductStatus;
import com.outlive.restaurant.dto.ProductType;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

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

    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity user;
}
