package com.example.pizza.decorator;

public class Mushroom extends ToppingDecorator {
    public Mushroom(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushroom";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 0.75;
    }
}
