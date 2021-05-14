package com.example.springdocker.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Philip Zamayeri
 * Date: 2021-05-14
 * Time: 13:04
 * Project: springdocker
 * Copyright: MIT
 */
class MyMathCalcTest {
    MyMathCalc myMathCalc;

    @BeforeEach
    void init(){ myMathCalc = new MyMathCalc(); }

    @DisplayName("Kollar så additionen stämmer")
    @Test
    void add() {
        int expected = 10;
        int actual = myMathCalc.add(5,5);
        assertEquals(expected,actual);
    }

    @DisplayName("Kollar så multiplikationen stämmer")
    @Test
    void multiply() {
        int expected = 25;
        int actual = myMathCalc.multiply(5,5);
        assertEquals(expected,actual);
    }

    @DisplayName("Kollar så divisionen stämmer")
    @Test
    void divide() {
        int expected = 2;
        double actual = myMathCalc.divide(10,5);
        assertEquals(expected,actual);
    }

    @DisplayName("Kollar så exception blir throwad")
    @Test
    void divide_throw() {
        assertThrows(ArithmeticException.class, () -> myMathCalc.divide(10,0));
    }
}