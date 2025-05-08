package com.example.pizza.decorator;

public class Olives extends ToppingDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return 1.00 + pizza.getCost();
    }
}