package com.outlive.restaurant.repository;

import com.outlive.restaurant.repository.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseEntity, Long> {

    @Query(value = "from ExpenseEntity t where creation BETWEEN :startDate AND :endDate")
    List<ExpenseEntity> getAllBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
