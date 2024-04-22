package com.outlive.restaurant.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Builder
@Getter
@Entity
@Table(name = "freights")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class FreightEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String cep;

    private String city;

    private BigDecimal price;

    @JoinColumn(name = "seller_id")
    @ManyToOne
    private SellerEntity seller;

    @Column(name = "delivery_estimate")
    private String deliveryEstimate;

}
