package com.example.springwebservice.controller.dto.request;

import com.example.springwebservice.model.entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {
    private int orderId;
    private int totalPrice;
    private String waiter;
    private Meal mealList;
}
