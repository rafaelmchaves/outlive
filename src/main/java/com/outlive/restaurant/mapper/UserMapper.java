package com.outlive.restaurant.mapper;

import com.outlive.restaurant.controller.dto.UserRequest;
import com.outlive.restaurant.controller.dto.UserResponse;
import com.outlive.restaurant.repository.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse convert(UserEntity userEntity);
    UserEntity convert(UserRequest userRequest);

}
