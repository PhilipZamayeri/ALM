package com.example.springdocker.service;

import com.example.springdocker.model.Food;
import com.example.springdocker.repository.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Created by Philip Zamayeri
 * Date: 2021-05-14
 * Time: 14:55
 * Project: springdocker
 * Copyright: MIT
 */

@ExtendWith(MockitoExtension.class)
class FoodServiceTest {
    FoodService foodService;

    @Mock
    FoodRepository foodRepository;


    @BeforeEach
    void init(){
        foodService = new FoodService(foodRepository);
    }

    @Test
    void getFoods() {
        Food food = new Food();
        food.setName("spagetti");

        List<Food> expected = Arrays.asList(food);
        when(foodRepository.findAll()).thenReturn(expected);

        List<Food> actual = foodService.getFoods();
        assertEquals(expected, actual);
        verify(foodRepository,times(1)).findAll();
    }

    @Test
    void saveNewFood() {
        Food food = new Food();
        food.setName("köttbullar");

        when(foodRepository.save(food)).thenReturn(food);

        Food food2 = new Food();
        food2.setName("köttbullar");

        assertEquals(food, foodService.saveNewFood(food2));
        verify(foodRepository,times(1)).save(any());
    }

    @Test
    void getCookableFoods() {
        Food food = new Food();
        food.setName("köttbullar");
        food.setCanICookIt(true);

        List<Food> expected = Arrays.asList(food);

        when(foodRepository.findFoodByCanICookIt(true)).thenReturn(expected);

        assertEquals(food.getName(), foodService.getCookableFoods().get(0));
    }
}