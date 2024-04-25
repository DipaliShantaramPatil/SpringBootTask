package com.task.registrationcrudoperation.repository;

import com.task.registrationcrudoperation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<Customer,Integer> {
}
