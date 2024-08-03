package com.outlive.restaurant.mapper;

import com.outlive.restaurant.controller.dto.ProductRequest;
import com.outlive.restaurant.controller.dto.ProductResponse;
import com.outlive.restaurant.repository.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity convert(ProductRequest productRequest);

    @Mapping(target = "image", constant = "https://static.itdg.com.br/images/auto-auto/5ffded59699ca5b00e18b140fece40e5/marmita-fitness.jpg")
    ProductResponse convert(ProductEntity productEntity);


    List<ProductResponse> convert(List<ProductEntity> productEntity);

}
