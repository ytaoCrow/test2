package com.example.springwebservice.controller.dto.request;

import com.example.springwebservice.model.entity.Meal;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {
    private int orderId;
    private int totalPrice;
    private String waiter;
    private Meal mealList;
}
