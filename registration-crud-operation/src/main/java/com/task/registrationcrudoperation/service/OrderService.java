package com.task.registrationcrudoperation.service;

import com.task.registrationcrudoperation.entity.CustomerOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    CustomerOrder createOrder(CustomerOrder customerOrder);

    List<CustomerOrder> getAllOrders();

    CustomerOrder getOrderById(int orderId);

    void deleteOrderById(int orderId);

    CustomerOrder updateOrder(CustomerOrder customerOrder);

    double calculateTotalAmount(double price, int quantity);

}
