package com.outlive.restaurant.repository;

import com.outlive.restaurant.repository.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
}
