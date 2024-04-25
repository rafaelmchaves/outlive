package com.outlive.restaurant.service;

import com.outlive.restaurant.controller.dto.AddressRequest;
import com.outlive.restaurant.controller.dto.AddressResponse;
import com.outlive.restaurant.mapper.AddressMapper;
import com.outlive.restaurant.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository repository;

    private final AddressMapper addressMapper;

    public AddressResponse create(AddressRequest addressRequest) {
        final var address = repository.save(addressMapper.get(addressRequest));
        return addressMapper.get(address);
    }
}
