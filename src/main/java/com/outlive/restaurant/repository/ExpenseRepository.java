package com.outlive.restaurant.repository;

import com.outlive.restaurant.repository.entity.ExpenseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseEntity, Long> {
}
