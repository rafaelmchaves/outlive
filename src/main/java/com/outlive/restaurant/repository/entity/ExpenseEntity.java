package com.outlive.restaurant.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Builder
@Getter
@Entity
@Table(name = "expenses")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private BigDecimal value;

    private LocalDateTime creation;

}
