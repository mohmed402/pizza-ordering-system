package com.example.pizza.dto;

import java.util.List;

public class OrderRequestDTO {
    private String customerName;
    private String pizzaType;
    private String pizzaSize;
    private String deliveryMethod;
    private List<String> toppings;

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getPizzaType() { return pizzaType; }
    public void setPizzaType(String pizzaType) { this.pizzaType = pizzaType; }

    public String getPizzaSize() { return pizzaSize; }  // ✅ Add getter
    public void setPizzaSize(String pizzaSize) { this.pizzaSize = pizzaSize; }  // ✅ Add setter

    public List<String> getToppings() { return toppings; }
    public void setToppings(List<String> toppings) { this.toppings = toppings; }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
