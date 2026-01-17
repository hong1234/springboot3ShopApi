package com.hong.demo.rest.shop.domain;

import java.math.BigDecimal;

public record Product(
    String productId, 
    String title, 
    String supplier, 
    String image,
    BigDecimal unitPrice
) {}
