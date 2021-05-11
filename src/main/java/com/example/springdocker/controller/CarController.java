package com.example.springdocker.controller;

import com.example.springdocker.model.Car;
import com.example.springdocker.model.Food;
import com.example.springdocker.service.CarService;
import com.example.springdocker.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Philip Zamayeri
 * Date: 2021-05-11
 * Time: 11:07
 * Project: springdocker
 * Copyright: MIT
 */
@RequiredArgsConstructor
@RestController
public class CarController {
    private final CarService service;

    @GetMapping("/cars")
    public List<Car> getCars() {
        return service.getCars();
    }

    @PostMapping("/cars")
    public void saveNewFood(@RequestBody Car car) {
        service.saveNewCar(car);
    }

    @GetMapping("/cars/active")
    public List<String> getRunnableCars() {
        return service.getActiveCars();
    }
}
