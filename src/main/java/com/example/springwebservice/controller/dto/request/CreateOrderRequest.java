package com.example.springwebservice.controller.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {

    private int orderId;
    private int totalPrice;
    private String waiter;
    private Map<String, Integer> mealMap;
}
