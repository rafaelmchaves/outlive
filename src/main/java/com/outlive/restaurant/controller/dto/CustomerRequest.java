package com.outlive.restaurant.controller.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class CustomerRequest {

    private String birthdate;
}
