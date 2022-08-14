package com.example.springwebservice.controller.dto.request;

import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMealRequest {

    private Integer mealId;
    private String mealName;
    private int price;
    private String description;
}
