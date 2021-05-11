package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.model.Food;
import com.example.springdocker.repository.CarRepository;
import com.example.springdocker.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Philip Zamayeri
 * Date: 2021-05-11
 * Time: 11:08
 * Project: springdocker
 * Copyright: MIT
 */
@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository repository;

    public List<Car> getCars() {
        return repository.findAll();
    }

    public void saveNewCar(Car car) {
        repository.save(car);
    }

    public List<String> getActiveCars() {
        // hämtar alla Foods som vi kan laga
        List<Car> activeCar = repository.findCarBy(true);

        // returnerar endast Food namnen i en lista
        return activeCar.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
