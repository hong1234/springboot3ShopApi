package com.hong.demo.rest.shop.domain;

import java.math.BigDecimal;

public record Product(
    String id, 
    String title, 
    String autor, 
    String image,
    BigDecimal unitPrice
) {}
