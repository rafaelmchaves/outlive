package com.outlive.restaurant.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.util.UUID;

@Setter
@Builder
@Getter
@Entity
@Table(name = "addresses")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String cep;

    private String address;

    private String city;

    private String state;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

}
