package com.example.springwebservice.controller;

import com.example.springwebservice.controller.dto.response.StatusResponse;
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
        List<Meal>response = this.mealService.getMealList();
        return response;
    }
    @GetMapping("/{id}")
    public Meal getMeal(@PathVariable int id) {

        Meal response = this.mealService.getMealById(id);
        return response;
    }
    @PostMapping("")
    public StatusResponse createMeal(@RequestBody CreateMealRequest request) {
        String response = (this.mealService.createMeal(request));
        return new StatusResponse(response);
    }

    @PutMapping("/{id}")
    public StatusResponse updateMeal(@PathVariable int id,
                                      @RequestBody UpdateMealRequest request) {
        String response = this.mealService.updateMeal(id,request);
        return new StatusResponse(response);
    }

    @DeleteMapping("/{id}")
    public StatusResponse deleteMeal(@PathVariable int id) {
        String reponse =this.mealService.deleteMeal(id);

        return new StatusResponse(reponse);
    }
}
