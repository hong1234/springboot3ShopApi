package com.hong.demo.rest.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.math.BigDecimal;

import com.hong.demo.rest.shop.domain.*;
import com.hong.demo.rest.shop.repository.*;

import jakarta.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when; 

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private CartRepository cartRepository;
    
    @InjectMocks
    private CartService cartService;

    private CustomerEntity customer;
    private ProductEntity product;
    private CartEntity cart;
    
    @BeforeEach
    void setup() {
        
        customer = CustomerEntity.builder().id(UUID.fromString("3395a42e-2d88-40de-b95f-e00e1502085b"))
        .email("test@gmail.com").username("test").password("test").address("test").phone("1234").build();

        CategoryEntity category = CategoryEntity.builder()
        .id(UUID.fromString("a1b9b31d-e73c-4112-af7c-b68530f38222"))
        .title("JavaScript")
        .build();
        
        product = ProductEntity.builder()
        .id(UUID.fromString("ca3d3d42-9379-4ba4-bf3e-a09ec3efbabe"))
        .title("JavaScript today")
        .description("news in JS")
        .supplier("Hong Le")
        .searchkeys("javascript news")
        .image("/images/Antifragile.jpg")
        .unitPrice(BigDecimal.valueOf(Double.valueOf("29.99")))
        .category(category)
        .build();

        cart = new CartEntity();
        cart.setId(UUID.fromString("6d62d909-f957-430e-8689-b5129c0bb75e"));
        cart.setCustomer(customer);
        // cart.setItems();

        CartItemEntity item = CartItemEntity.builder().id(UUID.fromString("b9f05831-6373-4303-b178-00ba325ca301"))
        .product(product).cart(cart).qty(1).unitPrice(new BigDecimal("29.99")).build();

        cart.addItem(item);
        cart.addItem(item);
    }

    @Test
    void addOneCartItem() {
        when(customerRepository.findById(UUID.fromString("3395a42e-2d88-40de-b95f-e00e1502085b"))).thenReturn(Optional.of(customer));
        // when(productRepository.findById(UUID.fromString("ca3d3d42-9379-4ba4-bf3e-a09ec3efbabe"))).thenReturn(Optional.of(product));
        when(cartRepository.save(any(CartEntity.class))).thenReturn(cart);

        CartItemDTO dto = new CartItemDTO();
        dto.setProductId("ca3d3d42-9379-4ba4-bf3e-a09ec3efbabe");
        dto.setModus("add");

        try {
            Cart cartNow = cartService.addItem("3395a42e-2d88-40de-b95f-e00e1502085b", dto);
            assertEquals(3, cartNow.items().get(0).qty(), "qty should match");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void removeOneCartItem() {
        when(customerRepository.findById(UUID.fromString("3395a42e-2d88-40de-b95f-e00e1502085b"))).thenReturn(Optional.of(customer));
        when(cartRepository.save(any(CartEntity.class))).thenReturn(cart);

        CartItemDTO dto = new CartItemDTO();
        dto.setProductId("ca3d3d42-9379-4ba4-bf3e-a09ec3efbabe");
        dto.setModus("remove");

        try {
            Cart cartNow = cartService.removeItem("3395a42e-2d88-40de-b95f-e00e1502085b", dto);
            assertEquals(1, cartNow.items().get(0).qty(), "qty should match");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
