package com.outlive.restaurant.mapper;

import com.outlive.restaurant.controller.dto.ProductRequest;
import com.outlive.restaurant.controller.dto.ProductResponse;
import com.outlive.restaurant.repository.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity convert(ProductRequest productRequest);

    ProductResponse convert(ProductEntity productEntity);

    List<ProductResponse> convert(List<ProductEntity> productEntity);

}
