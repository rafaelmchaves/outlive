package com.outlive.restaurant.service;

import com.outlive.restaurant.controller.dto.FreightRequest;
import com.outlive.restaurant.repository.FreightRepository;
import com.outlive.restaurant.repository.SellerRepository;
import com.outlive.restaurant.repository.entity.FreightEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FreightService {

    private final FreightRepository repository;

    private final SellerRepository sellerRepository;

    public void updateFreight(FreightRequest freightRequest) {

        final var seller = this.sellerRepository.findById(UUID.fromString(freightRequest.getSellerId()));
        if (seller.isEmpty()) {
            throw new RuntimeException("Seller not found");
        }

        final var freight = FreightEntity.builder().cep(freightRequest.getCep()).city(freightRequest.getCity()).price(freightRequest.getPrice())
                .deliveryEstimate(freightRequest.getDeliveryEstimate()).seller(seller.get()).build();

        repository.save(freight);
    }

    public Optional<FreightEntity> getFreight(String cep, String city, String sellerId) {

        var freight = repository.findByCepAndSellerId(cep, UUID.fromString(sellerId));
        if(freight == null) {
            freight = repository.findByCityAndCepAndSellerId(city, null, UUID.fromString(sellerId));
        }

        return Optional.ofNullable(freight);

    }
}
