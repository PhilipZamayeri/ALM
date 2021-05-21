package com.example.springdocker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Philip Zamayeri
 * Date: 2021-05-11
 * Time: 11:07
 * Project: springdocker
 * Copyright: MIT
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    String id;
    String name;
    boolean haveInsurance;
    boolean runnable;
}
