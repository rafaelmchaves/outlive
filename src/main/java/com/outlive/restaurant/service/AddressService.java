package com.outlive.restaurant.service;

import com.outlive.restaurant.controller.dto.AddressRequest;
import com.outlive.restaurant.controller.dto.AddressResponse;
import com.outlive.restaurant.mapper.AddressMapper;
import com.outlive.restaurant.repository.AddressRepository;
import com.outlive.restaurant.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository repository;

    private final UserRepository userRepository;

    private final AddressMapper addressMapper;

    public AddressResponse create(AddressRequest addressRequest) {
        final var user = userRepository.findById(UUID.fromString(addressRequest.getUserId()));
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        final var address = addressMapper.get(addressRequest);
        address.setUser(user.get());
        address.setCreation(LocalDateTime.now());
        final var savedAddress = repository.save(address);

        return addressMapper.get(savedAddress);
    }
}
