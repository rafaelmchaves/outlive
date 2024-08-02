package com.outlive.restaurant.controller;

import com.outlive.restaurant.controller.dto.ExpenseRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @PostMapping("/expenses")
    public ResponseEntity<Void> registerExpense(ExpenseRequest expenseRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
