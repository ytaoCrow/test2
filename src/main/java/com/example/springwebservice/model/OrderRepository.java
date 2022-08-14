package com.example.springwebservice.model;


import com.example.springwebservice.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findById(int orderId);
    long deleteById(int orderId);

}
