package com.example.springwebservice.service;

import com.example.springwebservice.controller.dto.request.CreateOrderRequest;
import com.example.springwebservice.controller.dto.request.UpdateOrderRequest;
import com.example.springwebservice.model.OrderRepository;
import com.example.springwebservice.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    List<Order> orderList;

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrderList() {
        List<Order> response = orderRepository.findAll();
        return response;
    }

    public Order getOrderById(int orderId) {

        return this.orderRepository.findById(orderId);
    }

    public String createOrder(CreateOrderRequest request) {

        Order order = new Order();

        order.setOrderId(request.getOrderId());
        order.setWaiter(request.getWaiter());
        order.setTotalPrice(request.getTotalPrice());
        order.setMealList(request.getMealList());

        this.orderRepository.save(order);
        return "OK";
    }

    public String updateUser(int orderId, UpdateOrderRequest request) {


        Order getOrder = this.orderRepository.findById(orderId);
        if (null == getOrder) {
            return "Fail";
        } else {

            getOrder.setOrderId(request.getOrderId());
            getOrder.setWaiter(request.getWaiter());
            getOrder.setTotalPrice(request.getTotalPrice());
            getOrder.setMealList(request.getMealList());

            this.orderRepository.save(getOrder);
            return "ok";
        }
    }

    public String deleteOrder(int orderId) {
        Order order = this.orderRepository.findById(orderId);
        if (null != order){

            this.orderRepository.deleteById(orderId);

            return "ok";
        }else {

            return "Fail";
        }

    }
}
