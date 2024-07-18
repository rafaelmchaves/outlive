package com.outlive.restaurant.exceptions.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    USER_NOT_FOUND("USR_01"),

    SELLER_NOT_FOUND("SLR_01"),

    CUSTOMER_NOT_FOUND("CST_01"),

    ADDRESS_NOT_FOUND("ADS_01"),

    ORDER_NOT_FOUND("ORD_01"),

    //Products code error
    PRODUCT_UNAVAILABLE("PRD_01"),
    PRODUCT_OUT_STOCK("PRD_02"),
    PRODUCT_PRICE_CHANGED("PRD_03"),
    PRODUCT_NOT_FOUND("PRD_04");

    private final String code;

}
