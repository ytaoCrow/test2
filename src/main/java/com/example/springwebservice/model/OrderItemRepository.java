package com.example.springwebservice.model;

import com.example.springwebservice.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    List<OrderItem> findAll();

    List<OrderItem> findAllByOrderId(Integer orderId);

    OrderItem findByOrderId(Integer orderId);

}
