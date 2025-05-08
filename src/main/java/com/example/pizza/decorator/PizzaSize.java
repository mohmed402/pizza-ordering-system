package com.example.pizza.decorator;

public enum PizzaSize {
    SMALL(0.0),
    MEDIUM(1.0),
    LARGE(2.0);

    private final double extraCost;

    PizzaSize(double extraCost) {
        this.extraCost = extraCost;
    }

    public double getExtraCost() {
        return extraCost;
    }
}
