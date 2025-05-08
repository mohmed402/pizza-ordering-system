package com.example.pizza.controller;

import com.example.pizza.decorator.*;
import com.example.pizza.model.Order;
import com.example.pizza.service.OrderService;
import com.example.pizza.strategy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.pizza.dto.OrderRequestDTO;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping
    public Order createOrder(@RequestParam String customerName) {
        return orderService.createOrder(customerName);
    }


    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }


    @PostMapping("/{id}/next")
    public Order advanceOrderState(@PathVariable Long id) {
        return orderService.advanceOrderState(id);
    }


    @PostMapping("/{id}/previous")
    public Order revertOrderState(@PathVariable Long id) {
        return orderService.revertOrderState(id);
    }

    @GetMapping("/{id}/status")
    public String getOrderStatus(@PathVariable Long id) {
        Order order = orderService.getOrder(id);
        if (order == null) return "Order not found.";
        return "Order " + id + " is currently in status: " + order.getStatus();
    }


    @PostMapping("/{id}/pay")
    public String payOrder(@PathVariable Long id, @RequestParam String method) {
        Order order = orderService.getOrder(id);
        if (order == null) return "Order not found.";

        System.out.println("method is: "+ method.toLowerCase().trim());
        switch (method.toLowerCase().trim()) {
            case "paypal" -> order.setPaymentStrategy(new PayPalPayment());
            case "creditcard" -> order.setPaymentStrategy(new CreditCardPayment());
            default -> {
                return "Unsupported payment method: " + method;
            }
        }

        order.pay();

        String formattedMethod = method.equalsIgnoreCase("paypal") ? "PayPal" :
                method.equalsIgnoreCase("creditcard") ? "Credit Card" :
                        method;
        return "Payment processed using " + formattedMethod;


    }

    @PostMapping("/custom")
    public Order createCustomOrder(@RequestBody OrderRequestDTO request) {

        Pizza pizza = PizzaFactory.createPizza(request.getPizzaType(), request.getPizzaSize());

        for (String topping : request.getToppings()) {
            switch (topping.toLowerCase().trim()) {
                case "mushrooms" -> pizza = new Mushroom(pizza);
                case "pepperoni" -> pizza = new Pepperoni(pizza);
                case "onions" -> pizza = new Onion(pizza);
                case "bell peppers" -> pizza = new BellPeppers(pizza);
                case "olives" -> pizza = new Olives(pizza);

                default -> throw new IllegalArgumentException("Unsupported topping: " + topping);
            }
        }

        Order order = orderService.createOrder(request.getCustomerName());
        order.setPizza(pizza);

        switch (request.getDeliveryMethod().toLowerCase().trim()) {
            case "delivery" -> order.setDeliveryStrategy(new HomeDeliveryStrategy());
            case "collection" -> order.setDeliveryStrategy(new CollectionStrategy());
            default -> throw new IllegalArgumentException("Invalid delivery method: " + request.getDeliveryMethod());
        }

        return order;
    }
}