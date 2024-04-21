package com.outlive.restaurant.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @GeneratedValue
    private UUID id;

    private String cep;

    private String city;

    private BigDecimal price;

}
