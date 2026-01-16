package com.hong.demo.rest.shop.domain;

import java.util.UUID;

import jakarta.persistence.*; 
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class CustomerEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String email; 
    private String username;
    private String password;
    // private String role;

    private String address;
    private String phone;

    // private $customerTelephone;
    // private $customerEmail;
    // private $customerAddress;

}
