package com.example.pizza.model;

import com.example.pizza.state.OrderState;
import com.example.pizza.state.OrderedState;
import com.example.pizza.strategy.DeliveryStrategy;
import com.example.pizza.strategy.PaymentStrategy;
import com.example.pizza.decorator.Pizza;


public class Order {
    private Long id;
    private String customerName;
    private OrderState state;
    private PaymentStrategy paymentStrategy;
    private DeliveryStrategy deliveryStrategy;

    private Pizza pizza;

    public Order(Long id, String customerName) {
        this.id = id;
        this.customerName = customerName;
        this.state = new OrderedState();
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public String getPizzaDescription() {
        return pizza != null ? pizza.getDescription() : "No pizza selected";
    }

    public double getPizzaCost() {
        return pizza != null ? pizza.getCost() : 0.0;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void pay() {
        if (paymentStrategy != null) {
            paymentStrategy.pay(getTotalCost());
        } else {
            System.out.println("Payment method not set.");
        }
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getStatus() {
        return state.getStatus();
    }

    public void nextState() {
        state.next(this);
    }

    public void previousState() {
        state.prev(this);
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void setDeliveryStrategy(DeliveryStrategy strategy) {
        this.deliveryStrategy = strategy;
    }

    public double getTotalCost() {
        return pizza.getCost() + deliveryStrategy.getDeliveryFee();
    }
}
