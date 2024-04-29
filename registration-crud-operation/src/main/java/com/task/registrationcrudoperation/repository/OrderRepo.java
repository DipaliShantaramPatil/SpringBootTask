package com.task.registrationcrudoperation.repository;

import com.task.registrationcrudoperation.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<CustomerOrder,Integer> {
}
