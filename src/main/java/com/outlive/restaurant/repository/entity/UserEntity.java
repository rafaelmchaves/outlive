package com.outlive.restaurant.repository.entity;

import com.outlive.restaurant.dto.UserStatus;
import com.outlive.restaurant.dto.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Builder
@Getter
@Entity
@Table(name = "users")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String phone;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @Column(name = "created_on")
    private LocalDateTime creation;

    @Column(name = "updated_on")
    private LocalDateTime update;

}
