package com.outlive.restaurant.exceptions;

import com.outlive.restaurant.exceptions.common.CustomException;
import com.outlive.restaurant.exceptions.common.ErrorCode;
import com.outlive.restaurant.exceptions.common.ExceptionMetadata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@ExceptionMetadata(httpStatus = HttpStatus.BAD_REQUEST)
public class CustomerNotFoundException extends CustomException {
    public CustomerNotFoundException(String customerId) {
        super("Customer not found", ErrorCode.SELLER_NOT_FOUND.getCode());
        log.error("Customer not found. Id: {}", customerId);
    }

}
