package com.outlive.restaurant.exceptions.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    USER_NOT_FOUND("USR_01"),
    SELLER_NOT_FOUND("SLR_01");

    private final String code;


}
