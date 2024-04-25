package com.outlive.restaurant.mapper;

import com.outlive.restaurant.controller.dto.AddressRequest;
import com.outlive.restaurant.controller.dto.AddressResponse;
import com.outlive.restaurant.repository.entity.AddressEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressEntity get(AddressRequest addressRequest);
    AddressResponse get(AddressEntity addressEntity);

}
