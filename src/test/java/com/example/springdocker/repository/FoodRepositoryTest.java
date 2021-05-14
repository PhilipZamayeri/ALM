package com.example.springdocker.repository;

import com.example.springdocker.model.Food;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Philip Zamayeri
 * Date: 2021-05-14
 * Time: 14:30
 * Project: springdocker
 * Copyright: MIT
 */

@DataMongoTest
class FoodRepositoryTest {

    @Autowired
    FoodRepository foodRepository;

    @AfterEach
    void deleteMock(){
        foodRepository.deleteAll();
    }

    @Test
    void findFoodByCanICookIt() {
        Food food = new Food();
        food.setName("spagetti");
        food.setCanICookIt(true);
        foodRepository.save(food);

        assertEquals(Arrays.asList(food), foodRepository.findFoodByCanICookIt(true));
    }

    @Test
    void findFoodByCanNotCookIt() {
        Food food = new Food();
        food.setName("ruttna köttbullar");
        food.setCanICookIt(false);
        foodRepository.save(food);

        assertEquals(Arrays.asList(food), foodRepository.findFoodByCanICookIt(false));
    }
}