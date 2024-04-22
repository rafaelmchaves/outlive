package com.outlive.restaurant.repository;

import com.outlive.restaurant.repository.entity.FreightEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FreightRepository extends CrudRepository<FreightEntity, Integer> {

    FreightEntity findByCepAndSellerId(String cep, UUID sellerId);
    FreightEntity findByCityAndCepAndSellerId(String city, String cep, UUID sellerId);

}
