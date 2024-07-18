package com.outlive.restaurant.service;

import com.outlive.restaurant.controller.dto.OrderProductRequest;
import com.outlive.restaurant.controller.dto.OrderProductStatus;
import com.outlive.restaurant.controller.dto.OrderRequest;
import com.outlive.restaurant.dto.OrderStatus;
import com.outlive.restaurant.dto.ProductStatus;
import com.outlive.restaurant.exceptions.AddressNotFoundException;
import com.outlive.restaurant.exceptions.CustomerNotFoundException;
import com.outlive.restaurant.exceptions.OrderNotFoundException;
import com.outlive.restaurant.repository.*;
import com.outlive.restaurant.repository.entity.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final ProductRepository productRepository;

    private final FreightService freightService;

    private final CustomerRepository customerRepository;

    private final AddressRepository addressRepository;

    private final OrderRepository orderRepository;

    private final OrderProductRepository orderProductRepository;

    public List<OrderEntity> getOrders(String customerId, int page, int size) {
        return orderRepository.findByCustomerId(UUID.fromString(customerId), PageRequest.of(page, size));
    }

    public List<OrderProductStatus> getOrdersDetails(String orderId) {

        final var productList = orderProductRepository.findByOrderId(UUID.fromString(orderId));

        return productList.stream().map(orderProductEntity -> OrderProductStatus.builder()
                .productName(orderProductEntity.getProduct().getName()).orderId(orderProductEntity.getId().toString())
                .value(orderProductEntity.getPrice().multiply(new BigDecimal(orderProductEntity.getQuantity())))
                .status(orderProductEntity.getStatus()).build()).toList();
    }

    @Transactional
    public void create(OrderRequest orderRequest) {

        final var customer = customerRepository.findById(UUID.fromString(orderRequest.getCustomerId()))
                .orElseThrow(() -> new CustomerNotFoundException(orderRequest.getCustomerId()));

        List<OrderProductEntity> orderProducts = getOrderProducts(orderRequest);

        //TODO find product and subtract stock
        final var address = addressRepository.findById(Long.valueOf(orderRequest.getAddressId())).orElseThrow(() -> new AddressNotFoundException("Address not found"));

        final var freight = freightService.getFreight(address.getCep(), address.getCity(), orderProducts.get(0).getProduct().getSeller().getId().toString())
                .orElseThrow(() -> new RuntimeException("There was a problem in our calculation of freight. Enter in contact with our support"));

        final OrderEntity order = createOrder(orderRequest, customer, address, freight, getTotalValueOrder(orderRequest));

        orderProducts.forEach(orderProductEntity -> orderProductEntity.setOrder(order));
        orderProductRepository.saveAll(orderProducts);

    }

    public void updateStatus(OrderStatus orderStatus, String id) {
        final var order = orderRepository.findById(UUID.fromString(id)).orElseThrow(() -> new OrderNotFoundException(id));
        order.setStatus(orderStatus);
        order.setUpdate(LocalDateTime.now());
        orderRepository.save(order);
    }

    private List<OrderProductEntity> getOrderProducts(OrderRequest orderRequest) {
        List<OrderProductEntity> orderProductEntities = new ArrayList<>();

        for(OrderProductRequest orderProductRequest: orderRequest.getOrders()) {
            final var product = productRepository.findById(UUID.fromString(orderProductRequest.getProductId()))
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            validateProduct(orderProductRequest, product);

            orderProductEntities.add(OrderProductEntity.builder()
                    .product(product).status(OrderStatus.CREATED).quantity(orderProductRequest.getAmount())
                    .price(product.getPrice()).build());

            updateStock(product);
        }

        return orderProductEntities;
    }

    private void updateStock(ProductEntity product) {
        product.setStockAmount(product.getStockAmount() - 1);
        productRepository.save(product);
    }

    private static void validateProduct(OrderProductRequest orderProduct, ProductEntity product) {
        if (ProductStatus.UNAVAILABLE.equals(product.getStatus())) {
            throw new RuntimeException("Product is unavailable");
        }
        if (isOutOfStock(product)) {
            throw new RuntimeException("Product is out of stock");
        }
        if (!orderProduct.getPrice().equals(product.getPrice())) {
            throw new RuntimeException("The price of product changed");
        }
    }

    private static boolean isOutOfStock(ProductEntity product) {
        return product.getFraction().compareTo(BigDecimal.ZERO) <= 0;
    }

    private static BigDecimal getTotalValueOrder(OrderRequest orderRequest) {
        return orderRequest.getOrders().stream()
                .map(orderProductRequest -> orderProductRequest.getPrice().multiply(BigDecimal.valueOf(orderProductRequest.getAmount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private OrderEntity createOrder(OrderRequest orderRequest, CustomerEntity customer, AddressEntity address, FreightEntity freight, BigDecimal totalValueOrder) {
        final var order = OrderEntity.builder().itemsAmount(orderRequest.getOrders().size()).creation(LocalDateTime.now())
                    .paymentMethod(orderRequest.getPaymentMethod()).status(OrderStatus.CREATED).freightValue(freight.getPrice())
                .totalValue(totalValueOrder).customer(customer)
                .address(address)
                .build();
        orderRepository.save(order);
        return order;
    }

}
