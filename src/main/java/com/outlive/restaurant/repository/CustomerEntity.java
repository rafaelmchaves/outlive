package com.outlive.restaurant.repository;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Setter
@Builder
@Getter
@Entity
@Table(name = "customers")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    @Column(name = "user_id")
    private String userId;

    @Column(name = "birthdate")
    private String birthdate;
}
