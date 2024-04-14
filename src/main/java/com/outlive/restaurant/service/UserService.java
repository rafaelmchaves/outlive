package com.outlive.restaurant.service;

import com.outlive.restaurant.controller.dto.UserRequest;
import com.outlive.restaurant.controller.dto.UserResponse;
import com.outlive.restaurant.dto.UserType;
import com.outlive.restaurant.mapper.UserMapper;
import com.outlive.restaurant.repository.*;
import com.outlive.restaurant.repository.entity.CustomerEntity;
import com.outlive.restaurant.repository.entity.SellerEntity;
import com.outlive.restaurant.repository.entity.UserEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    private final SellerRepository sellerRepository;

    private final CustomerRepository customerRepository;

    private final UserMapper userMapper;

    @Transactional
    public UserResponse create(UserRequest userRequest) {

        final var user = userMapper.convert(userRequest);
        user.setCreation(LocalDateTime.now());

        final var persistedUser = this.repository.save(user);

        if (userRequest.getType().equals(UserType.SELLER)) {
            saveSeller(userRequest, persistedUser);
        } else {
            saveCustomer(userRequest, persistedUser);
        }

        return userMapper.convert(persistedUser);
    }

    private void saveCustomer(UserRequest userRequest, UserEntity persistedUser) {
        this.customerRepository.save(CustomerEntity.builder().user(persistedUser)
                .birthdate(userRequest.getCustomer().getBirthdate()).build());
    }

    private void saveSeller(UserRequest userRequest, UserEntity persistedUser) {
        final var seller = userRequest.getSeller();
        this.sellerRepository.save(SellerEntity.builder().user(persistedUser).address(seller.getAddress())
                        .city(seller.getCity()).state(seller.getState()).description(seller.getDescription())
                        .zipCode(seller.getZipCode())
                .build());
    }
}
