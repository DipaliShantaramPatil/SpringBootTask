package com.task.registrationcrudoperation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {

    @Id
    private int orderId;
    private String name;
    private Long quantity;
    private double price;

    
}
