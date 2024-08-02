package com.outlive.restaurant.service;

import com.outlive.restaurant.controller.dto.ExpenseRequest;
import com.outlive.restaurant.repository.ExpenseRepository;
import com.outlive.restaurant.repository.entity.ExpenseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public void saveExpense(ExpenseRequest expenseRequest) {
        final var expense = ExpenseEntity.builder().name(expenseRequest.getName()).type(expenseRequest.getType()).value(expenseRequest.getValue())
                .creation(LocalDateTime.now()).build();
        expenseRepository.save(expense);
    }
}
