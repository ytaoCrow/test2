package com.example.springwebservice.model;


import com.example.springwebservice.model.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal,Integer> {

    Meal findById(int mealId);
    long deleteById(int mealId);

}
