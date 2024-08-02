package com.outlive.restaurant.controller;

import com.outlive.restaurant.controller.dto.ExpenseRequest;
import com.outlive.restaurant.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/expenses")
    public ResponseEntity<Void> registerExpense(@RequestBody ExpenseRequest expenseRequest) {
        expenseService.saveExpense(expenseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
