package com.task.registrationcrudoperation.service;

import com.task.registrationcrudoperation.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RegistrationService {

    Customer createUser(Customer registration);

    List<Customer> getAllUsers();

    Optional<Customer> getUserById(int id);

    Customer updateUser(int id, Customer registration);

    void deleteUserById(int id);
}
