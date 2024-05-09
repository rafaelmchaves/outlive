package com.outlive.restaurant.exceptions.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    USER_NOT_FOUND("USR_01"),
    SELLER_NOT_FOUND("SLR_01"),
    CUSTOMER_NOT_FOUND("CUS_01"),
    ADDRESS_NOT_FOUND("ADD_01");

    private final String code;


}
