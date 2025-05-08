package com.example.pizza.decorator;

public class PizzaFactory {
    public static Pizza createPizza(String type, String sizeString) {
        PizzaSize size = PizzaSize.valueOf(sizeString.toUpperCase());

        Pizza pizza;
        switch (type.toLowerCase()) {
            case "margherita" -> pizza = new Margherita();
            case "vegetable" -> pizza = new Vegetable();
            default -> throw new IllegalArgumentException("Unknown pizza type: " + type);
        }

        pizza.setSize(size);
        return pizza;
    }
}
