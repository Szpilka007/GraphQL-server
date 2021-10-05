package com.oktadeveloper.graphqldemo.service;

import com.oktadeveloper.graphqldemo.model.Food;
import com.oktadeveloper.graphqldemo.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getFoods() {
        return foodRepository.findAll();
    }

    public Optional<Food> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    public Food updateFood(Food food) { return foodRepository.save(food);};

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }

    public boolean isGood(Food food) {
        return !Arrays.asList("Avocado", "Spam").contains(food.getName());
    }

    public boolean isTasty(Food food) {
        return !isGood(food);
    }

    public int countPrice() {
        return foodRepository.findAll()
                .stream()
                .map(Food::getPrice)
                .reduce(Integer::sum)
                .orElseThrow(() -> new RuntimeException("Error while summing"));
    }

    public void throwException() {
        throw new RuntimeException("No expected exception");
    }
}
