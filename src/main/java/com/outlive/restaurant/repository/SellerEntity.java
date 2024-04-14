package com.outlive.restaurant.repository;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Setter
@Builder
@Getter
@Entity
@Table(name = "sellers")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class SellerEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity user;

    private String description;

    private String city;

    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    private String address;
}
