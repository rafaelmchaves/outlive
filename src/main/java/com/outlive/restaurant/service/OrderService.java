package com.outlive.restaurant.service;

import com.outlive.restaurant.controller.dto.OrderProductRequest;
import com.outlive.restaurant.controller.dto.OrderRequest;
import com.outlive.restaurant.dto.ProductStatus;
import com.outlive.restaurant.repository.ProductRepository;
import com.outlive.restaurant.repository.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final ProductRepository productRepository;

    private final FreightService freightService;

    private final UserService userService;

    public void create(OrderRequest orderRequest) {

        List<ProductEntity> productEntities = new ArrayList<>();
        for(OrderProductRequest orderProduct: orderRequest.getOrders()) {

            final var product = productRepository.findById(UUID.fromString(orderProduct.getProductId())).orElseThrow(() -> new RuntimeException("Product not found"));

            if (ProductStatus.UNAVAILABLE.equals(product.getStatus())) {
                throw new RuntimeException("Product is unavailable");
            }
            if (isOutOfStock(product)) {
                throw new RuntimeException("Product is out of stock");
            }

            productEntities.add(product);
        }


//        OrderEntity.builder().itemsAmount(orderRequest.getOrders().size()).creation(LocalDateTime.now())
//                    .paymentMethod(orderRequest.getPaymentMethod()).status("CREATED")
//            .user()
//
//            build();


    }

    private static boolean isOutOfStock(ProductEntity product) {
        return product.getQuantity().compareTo(BigDecimal.ZERO) <= 0;
    }
}
