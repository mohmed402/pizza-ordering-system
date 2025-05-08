package com.example.pizza;

import com.example.pizza.decorator.*;
import com.example.pizza.model.Order;
import com.example.pizza.service.OrderService;
import com.example.pizza.strategy.PayPalPayment;
import com.example.pizza.strategy.PaymentStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PizzaOrderingApplication {
    public static void main(String[] args) {
        SpringApplication.run(PizzaOrderingApplication.class, args);

        Order order = new Order(1L, "Ali");


        Pizza pizza = new Margherita();
        pizza = new Mushroom(pizza);
        pizza = new Pepperoni(pizza);

        order.setPizza(pizza);
        pizza.getCost();

        PaymentStrategy paypal = new PayPalPayment();
        order.setPaymentStrategy(paypal);
        paypal.pay(pizza.getCost());

        System.out.println("Order for: " + order.getCustomerName());
        System.out.println("Pizza: " + order.getPizzaDescription());
        System.out.println("Total: £" + order.getPizzaCost());


    }
}
