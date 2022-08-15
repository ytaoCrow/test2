package com.example.springwebservice.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMealRequest {
    private Integer mealId;
    private String mealName;
    private int price;
    private String description;
}
