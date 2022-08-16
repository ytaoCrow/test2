package com.example.springwebservice.controller;

import com.example.springwebservice.controller.dto.response.StatusResponse;
import com.example.springwebservice.controller.dto.request.CreateOrderRequest;
import com.example.springwebservice.model.entity.Order;
import com.example.springwebservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    List<Order> orderList;

   @Autowired
   private OrderService orderService;

    @GetMapping()
    public List<Map<String, Object>> getAllOrders() {

        List<Map<String, Object>> response = this.orderService.getOrderList();
        return response;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getOrder(@PathVariable int id) {
        Map<String, Object> response = this.orderService.getOrderById(id);
        return response;
    }

    @PostMapping()
    public StatusResponse createOrder(@RequestBody CreateOrderRequest request) {
        String response = (this.orderService.createOrder(request));
        return new StatusResponse(response);
    }
}
