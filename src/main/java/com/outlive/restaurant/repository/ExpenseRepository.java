package com.outlive.restaurant.repository;

import com.outlive.restaurant.repository.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExpenseRepository extends CrudRepository<CustomerEntity, UUID> {
}
