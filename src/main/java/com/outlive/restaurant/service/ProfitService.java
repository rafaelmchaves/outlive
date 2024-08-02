package com.outlive.restaurant.service;

import com.outlive.restaurant.controller.dto.ProfitResponse;
import com.outlive.restaurant.repository.ExpenseRepository;
import com.outlive.restaurant.repository.OrderRepository;
import com.outlive.restaurant.repository.entity.ExpenseEntity;
import com.outlive.restaurant.repository.entity.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ProfitService {

    private final OrderRepository orderRepository;

    private final ExpenseRepository expenseRepository;

    public ProfitResponse getBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        final var profitResponse = ProfitResponse.builder().build();

        final var orders = orderRepository.findAllBetweenDate(startDate, endDate);
        profitResponse.setTotalValueSold(orders.stream().map(OrderEntity::getTotalValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        profitResponse.setTotalSold(orders.size());

        final var expenses = expenseRepository.getAllBetweenDates(startDate, endDate);
        profitResponse.setCostTotal(expenses.stream().map(ExpenseEntity::getValue).reduce(BigDecimal.ZERO, BigDecimal::add));

        profitResponse.setProfit(profitResponse.getTotalValueSold().subtract(profitResponse.getCostTotal()));

        return profitResponse;
    }
}
