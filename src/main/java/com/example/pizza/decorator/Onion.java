package com.example.pizza.decorator;

public class Onion extends ToppingDecorator {
    public Onion(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Onion";
    }

    @Override
    public double getCost() {
        return 1.50 + pizza.getCost();
    }
}