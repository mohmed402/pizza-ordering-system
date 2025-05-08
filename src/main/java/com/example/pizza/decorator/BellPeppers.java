package com.example.pizza.decorator;

public class BellPeppers extends ToppingDecorator {
    public BellPeppers(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Bell Peppers";
    }

    @Override
    public double getCost() {
        return 1.50 + pizza.getCost();
    }
}