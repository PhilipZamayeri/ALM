package com.example.springdocker.service;

/**
 * Created by Philip Zamayeri
 * Date: 2021-05-12
 * Time: 13:56
 * Project: springdocker
 * Copyright: MIT
 */
public class MyMathCalc {
    public int add(int a, int b){ return a+b; }
    public int multiply(int a, int b){ return a*b; }

    public double divide(int a, int b){
        if (b == 0){
            throw new ArithmeticException("Du får ej dividera med 0");
        }
        return a/b;
    }
}
