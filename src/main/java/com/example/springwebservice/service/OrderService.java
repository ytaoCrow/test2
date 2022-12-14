package com.example.springwebservice.service;

import com.example.springwebservice.controller.dto.request.CreateOrderRequest;
import com.example.springwebservice.model.MealRepository;
import com.example.springwebservice.model.OrderItemRepository;
import com.example.springwebservice.model.OrderRepository;
import com.example.springwebservice.model.entity.Meal;
import com.example.springwebservice.model.entity.Order;
import com.example.springwebservice.model.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<Map<String,Object>> getOrderList() {

        List<Map<String,Object>> response = new ArrayList<>();
        List<Order> orderList = this.orderRepository.findAll();
        List<OrderItem> orderItemList;

        for(Order eachOrder : orderList){
            orderItemList = this.orderItemRepository.findAllByOrderId(eachOrder.getOrderId());
            List<Map<String, Object>> orderItems = new ArrayList<>();
            for(OrderItem orderItem : orderItemList){
                orderItems.add(Map.of("mealId",orderItem.getMealId()));
            }
            response.add(Map.of("order",eachOrder,"orderItem",orderItems));
        }
        return response;
    }

    public Map<String,Object> getOrderById(Integer id) {

        Map<String,Object> response;

        List<Map<String, Object>> orderItems = new ArrayList<>();

        System.out.println(id);

        Order order = this.orderRepository.findByOrderId(id);
        System.out.println(order.getOrderId());

        List<OrderItem> orderItemList;
        orderItemList = this.orderItemRepository.findAllByOrderId(order.getOrderId());
        if(orderItemList != null) {
            for (OrderItem orderItem : orderItemList) {
                orderItems.add(Map.of("mealId", orderItem.getMealId()));
            }
        }
        response = Map.of("order",order,"orderItem",orderItems);

        return response;
    }

    public String createOrder(CreateOrderRequest request) {

        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();

        Meal bufMeal;
        OrderItem bufOrderItem;

        try {
            order.setWaiter(request.getWaiter());
            Integer total = 0;
//            System.out.println(total);
//            System.out.println(request.getMealMap().toString());
            Map<String, Integer> itemMap = request.getMealMap();
            Set<String> itemKey = itemMap.keySet();
//            System.out.println(itemKey);
            for (String item : itemKey) {
                Optional<Meal> meal = this.mealRepository.findByMealName(item);
                if (meal.isPresent()) {
//                    System.out.println(meal.get().getMealName());
                    total += meal.get().getPrice() * (Integer) itemMap.get(item);
                    bufOrderItem = new OrderItem();
                    bufOrderItem.setCount((Integer) itemMap.get(item));
                    bufOrderItem.setMealId(meal.get().getMealId());
                    orderItems.add(bufOrderItem);
                }
                else{
                    System.out.println(item+"?????????");
                }
            }
//            System.out.println(total);
            order.setTotalPrice(total);
//            System.out.println("orderItems" + orderItems);
//            System.out.println("| " + order.getOrderId() + " | "  + order.getWaiter());
            this.orderRepository.save(order);
            orderItems.forEach( e -> e.setOrderId(order.getOrderId()));
            this.orderItemRepository.saveAll(orderItems);

        }catch( Exception e){
            e.printStackTrace();
            System.out.println("???????????????????????????");
            return "code: 500, ???????????????";
        }

        return "code: 200, orderId : " + order.getOrderId();
    }
}
