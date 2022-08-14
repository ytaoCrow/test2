package com.example.springwebservice.controller;

import com.example.springwebservice.controller.dto.reponse.StatusResponse;
import com.example.springwebservice.controller.dto.request.CreateOrderRequest;
import com.example.springwebservice.controller.dto.request.UpdateOrderRequest;
import com.example.springwebservice.model.entity.Order;
import com.example.springwebservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

   @Autowired
   private OrderService orderService;

    @GetMapping()
    public List<Order> getAllOrders() {
        List<Order> orderList =this.orderService.getOrderList();
        return orderList;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {

        Order order = this.orderService.getOrderById(id);

        return order;
    }

    @PostMapping()
    public StatusResponse createOrder(@RequestBody CreateOrderRequest request) {
        String order = (this.orderService.createOrder(request));
        return new StatusResponse(order);
    }

    @PutMapping("/{id}")
    public StatusResponse updateOrder(@PathVariable int id,
                                      @RequestBody UpdateOrderRequest request) {
        String order = this.orderService.updateUser(id,request);
        return new StatusResponse(order);
    }
    @DeleteMapping("/{id}")
    public StatusResponse deleteOrder(@PathVariable int id) {
        String order =this.orderService.deleteOrder(id);

        return new StatusResponse(order);
    }
}
