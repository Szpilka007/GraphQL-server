package com.oktadeveloper.graphqldemo;

import com.oktadeveloper.graphqldemo.model.Food;
import com.oktadeveloper.graphqldemo.service.FoodService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class GraphqldemoApplication {

    List<String> companies = Stream.of("Nestle", "Coke Oryginal", "Polaris", "Salato").collect(Collectors.toList());

    public static void main(String[] args) {
        SpringApplication.run(GraphqldemoApplication.class, args);
    }

    @Bean
    ApplicationRunner init(FoodService foodService) {
        return args -> {
            Stream.of("Pizza", "Ham", "Eggs", "Avocado", "Tortilla", "Ice cream", "Bread", "Butter", "Coke").forEach(name -> {
                Food food = new Food();
                food.setName(name);
                food.setCompany(companies.get(new Random().nextInt(4)));
                food.setPrice(new Random().nextInt(50));
                food.setAmount(new Random().nextInt(10));
                foodService.saveFood(food);
            });
        };
    }

}
