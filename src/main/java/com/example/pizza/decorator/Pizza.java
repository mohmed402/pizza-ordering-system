package com.example.pizza.decorator;

public abstract class Pizza {
    protected PizzaSize size = PizzaSize.SMALL;

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public PizzaSize getSize() {
        return size;
    }

    public abstract String getDescription();
    public abstract double getCost();
}
