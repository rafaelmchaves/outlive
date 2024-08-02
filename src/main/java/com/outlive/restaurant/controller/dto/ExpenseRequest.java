package com.outlive.restaurant.controller.dto;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class ExpenseRequest {

    private String name;
    private String type;
    private BigDecimal value;


}
