package com.oktadeveloper.graphqldemo.controller;

import com.oktadeveloper.graphqldemo.model.Food;
import com.oktadeveloper.graphqldemo.service.FoodService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.List;
import java.util.Optional;

@GraphQLApi
@Controller
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GraphQLQuery(name = "foods")
    public List<Food> getFoods() {
        return foodService.getFoods();
    }

    @GraphQLQuery(name = "food")
    public Optional<Food> getFoodById(@GraphQLArgument(name = "id") Long id) {
        return foodService.getFoodById(id);
    }

    @GraphQLMutation(name = "saveFood")
    public Food saveFood(@GraphQLArgument(name = "food") Food food) {
        return foodService.saveFood(food);
    }

    @GraphQLMutation(name = "deleteFood")
    public boolean deleteFood(@GraphQLArgument(name = "id") Integer id) {
        foodService.deleteFood(id.longValue());
        return true;
    }

    @GraphQLMutation(name = "updateFood")
    public Food updateFood(@GraphQLArgument(name = "food") Food food) {
        food.setId(food.getTemporaryId().longValue());
        return foodService.updateFood(food);
    }

    @GraphQLQuery(name = "isGood")
    public boolean isGood(@GraphQLContext Food food) {
        return foodService.isGood(food);
    }

    @GraphQLQuery(name = "isTasty")
    public boolean isTasty(@GraphQLContext Food food) {
        return foodService.isTasty(food);
    }

    @GraphQLMutation(name = "countPrice")
    public long countPrice() {
        return foodService.countPrice();
    }

    @GraphQLMutation(name = "exception")
    public void getException() {
        foodService.throwException();
    }
}
