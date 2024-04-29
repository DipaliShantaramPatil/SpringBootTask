package com.task.registrationcrudoperation.controller;

import com.task.registrationcrudoperation.entity.CustomerOrder;
import com.task.registrationcrudoperation.exception.ErrorResponse;
import com.task.registrationcrudoperation.exception.SuccessResponse;
import com.task.registrationcrudoperation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@RequestBody CustomerOrder customerOrder) {
        try {
            CustomerOrder createdOrder = orderService.createOrder(customerOrder);
            SuccessResponse response = new SuccessResponse(LocalDateTime.now(), HttpStatus.CREATED.value(), "Order created successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/order")
    public ResponseEntity<?> getAllOrders() {
        try {
            List<CustomerOrder> orders = orderService.getAllOrders();
            return ResponseEntity.ok().body(orders);
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable int orderId) {
        try {
            CustomerOrder order = orderService.getOrderById(orderId);
            if (order == null) {
                ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Order not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            return ResponseEntity.ok().body(order);
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<?> deleteOrderById(@PathVariable int orderId) {
        try {
            orderService.deleteOrderById(orderId);
            SuccessResponse response = new SuccessResponse(LocalDateTime.now(), HttpStatus.OK.value(), "Order deleted successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<?> updateOrder(@PathVariable int orderId, @RequestBody CustomerOrder customerOrder) {
        try {
            CustomerOrder existingOrder = orderService.getOrderById(orderId);
            if (existingOrder == null) {
                ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Order not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            customerOrder.setOrder_Id(orderId);
            CustomerOrder updatedOrder = orderService.updateOrder(customerOrder);
            return ResponseEntity.ok().body(updatedOrder);
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

//    @GetMapping("/totalAmount/{orderId}")
//    public ResponseEntity<Double> getTotalAmount(@PathVariable int orderId) {
//        CustomerOrder order = orderService.getOrderById(orderId);
//        if (order == null) {
//            return ResponseEntity.notFound().build();
//        }
//        double totalAmount = orderService.calculateTotalAmount(order.getPrice(), order.getQuantity());
//        return ResponseEntity.ok(totalAmount);
//    }

    @GetMapping("/totalAmount/{orderId}")
    public ResponseEntity<?> getTotalAmount(@PathVariable int orderId) {
        try {
            CustomerOrder order = orderService.getOrderById(orderId);
            if (order == null) {
                ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Order not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            double totalAmount = orderService.calculateTotalAmount(order.getPrice(), order.getQuantity());
            SuccessResponse response = new SuccessResponse(LocalDateTime.now(), HttpStatus.OK.value(), "Total amount calculated successfully: " + totalAmount);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    }






