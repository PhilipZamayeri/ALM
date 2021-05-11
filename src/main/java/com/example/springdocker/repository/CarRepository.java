package com.example.springdocker.repository;

import com.example.springdocker.model.Car;
import com.example.springdocker.model.Food;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Philip Zamayeri
 * Date: 2021-05-11
 * Time: 11:08
 * Project: springdocker
 * Copyright: MIT
 */
@Repository
public interface CarRepository extends MongoRepository<Car, String> {

    List<Car> findCarBy(boolean isActive);
}
