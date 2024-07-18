package com.outlive.restaurant.exceptions;

import com.outlive.restaurant.exceptions.common.CustomException;
import com.outlive.restaurant.exceptions.common.ErrorCode;
import com.outlive.restaurant.exceptions.common.ExceptionMetadata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@ExceptionMetadata(httpStatus = HttpStatus.BAD_REQUEST)
public class OrderNotFoundException extends CustomException {
    public OrderNotFoundException(String orderId) {
        super("Order not found", ErrorCode.ORDER_NOT_FOUND.getCode());
        log.error("Order not found. Id: {}", orderId);
    }

}
