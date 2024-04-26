package com.outlive.restaurant.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Builder
@Getter
@Entity
@Table(name = "addresses")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String cep;

    private String address;

    private String city;

    private String state;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity user;

    @Column(name = "creation_on")
    private LocalDateTime creation;

}
