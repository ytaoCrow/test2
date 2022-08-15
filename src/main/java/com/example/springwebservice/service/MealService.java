package com.example.springwebservice.service;

import com.example.springwebservice.controller.dto.request.CreateMealRequest;
import com.example.springwebservice.controller.dto.request.CreateOrderRequest;
import com.example.springwebservice.controller.dto.request.UpdateMealRequest;
import com.example.springwebservice.controller.dto.request.UpdateOrderRequest;
import com.example.springwebservice.model.MealRepository;
import com.example.springwebservice.model.entity.Meal;
import com.example.springwebservice.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    List<Meal> mealList;

    @Autowired
    private MealRepository mealRepository;

    public List<Meal> getMealList() {

        List<Meal> response = this.mealRepository.findAll();
        System.out.println(response.toString());
        return response;

    }

    public Meal getMealById(int mealId) {

        return this.mealRepository.findById(mealId);
    }

    public String createMeal(CreateMealRequest request) {

         Meal meal = new Meal();

         meal.setMealId(request.getMealId());
         meal.setMealName(request.getMealName());
         meal.setPrice(request.getPrice());
         meal.setDescription(request.getDescription());

        this.mealRepository.save(meal);
        return "OK";
    }
    public String updateMeal(int mealId, UpdateMealRequest request) {


        Meal getMeal = this.mealRepository.findById(mealId);
        if (null == getMeal) {
            return "Fail";
        } else {

            System.out.println(getMeal);
            System.out.println(request);

            getMeal.setMealId(mealId);
            getMeal.setMealName(request.getMealName());
            getMeal.setPrice(request.getPrice());
            getMeal.setDescription(request.getDescription());

            this.mealRepository.save(getMeal);
            return "ok";
        }
    }

    public String deleteMeal(int mealId) {
        Meal meal = this.mealRepository.findById(mealId);
        if (null != meal){

            this.mealRepository.delete(meal);

            return "ok";
        }else {

            return "Fail";
        }

    }
}
