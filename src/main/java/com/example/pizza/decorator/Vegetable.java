package com.example.pizza.decorator;

public class Vegetable extends Pizza {
    @Override
    public String getDescription() {
        return size.name() + " Vegetable";
    }

    @Override
    public double getCost() {
        return 3.50 + size.getExtraCost();
    }
}