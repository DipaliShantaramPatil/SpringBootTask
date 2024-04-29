package com.task.registrationcrudoperation.serviceImpl;

import com.task.registrationcrudoperation.entity.CustomerOrder;
import com.task.registrationcrudoperation.repository.OrderRepo;
import com.task.registrationcrudoperation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;


    @Override
    public CustomerOrder createOrder(CustomerOrder customerOrder) {
        return orderRepo.save(customerOrder);
    }

    @Override
    public List<CustomerOrder> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public CustomerOrder getOrderById(int orderId) {
        Optional<CustomerOrder> optionalCustomerOrder = orderRepo.findById(orderId);
        return optionalCustomerOrder.orElse(null);
    }

    @Override
    public void deleteOrderById(int orderId) {
        orderRepo.deleteById(orderId);
    }

    @Override
    public CustomerOrder updateOrder(CustomerOrder customerOrder) {
        return orderRepo.save(customerOrder);
    }

    @Override
    public double calculateTotalAmount(double price, int quantity) {
        return price * quantity;
    }


}
