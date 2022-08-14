package com.example.springwebservice.controller;

import com.example.springwebservice.controller.dto.reponse.StatusResponse;
import com.example.springwebservice.controller.dto.request.CreateMealRequest;
import com.example.springwebservice.controller.dto.request.UpdateMealRequest;
import com.example.springwebservice.model.entity.Meal;
import com.example.springwebservice.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping()
    public List<Meal> getAllMeals() {
        List<Meal> mealList = this.mealService.getMealList();
        return mealList;
    }
    @GetMapping("/{id}")
    public Meal getMeal(@PathVariable int id) {

        Meal meal = this.mealService.getMealById(id);
        return meal;
    }
    @PostMapping()
    public StatusResponse createMeal(@RequestBody CreateMealRequest request) {
        String meal = (this.mealService.createMeal(request));
        return new StatusResponse(meal);
    }

    @PutMapping("/{id}")
    public StatusResponse updateMeal(@PathVariable int id,
                                      @RequestBody UpdateMealRequest request) {
        String meal = this.mealService.updateMeal(id,request);
        return new StatusResponse(meal);
    }

    @DeleteMapping("/{id}")
    public StatusResponse deleteMeal(@PathVariable int id) {
        String meal =this.mealService.deleteMeal(id);

        return new StatusResponse(meal);
    }
}
