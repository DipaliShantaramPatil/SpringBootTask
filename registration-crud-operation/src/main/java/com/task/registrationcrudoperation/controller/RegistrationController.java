package com.task.registrationcrudoperation.controller;

import com.task.registrationcrudoperation.entity.Customer;
import com.task.registrationcrudoperation.exception.ErrorResponse;
import com.task.registrationcrudoperation.exception.SuccessResponse;
import com.task.registrationcrudoperation.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/registrations")
    public ResponseEntity<?> createUser(@RequestBody Customer registration) {
//        System.out.println("registration");
        try {
            Customer createdUser = registrationService.createUser(registration);
            SuccessResponse response = new SuccessResponse(LocalDateTime.now(), HttpStatus.CREATED.value(), "User created successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @GetMapping("/registration")
    public ResponseEntity<?> getAllUsers() {
        try {
            List<Customer> users = registrationService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/registration/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        try {
            Optional<Customer> registration = registrationService.getUserById(id);
            if (registration.isPresent()) {
                return ResponseEntity.ok(registration.get());
            } else {
                ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "User not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @PutMapping("/registration/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody Customer registration) {
        try {
            Customer updatedUser = registrationService.updateUser(id, registration);
            if (updatedUser != null) {
                SuccessResponse response = new SuccessResponse(LocalDateTime.now(), HttpStatus.OK.value(), "User updated successfully");
                return ResponseEntity.ok(response);
            } else {
                ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "User not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping("/registration/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable int id) {
        try {
            registrationService.deleteUserById(id);
            SuccessResponse response = new SuccessResponse(LocalDateTime.now(), HttpStatus.OK.value(), "User deleted successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}



