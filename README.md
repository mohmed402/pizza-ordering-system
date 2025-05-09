# 🍕 Pizza Ordering System (Backend)

This is the backend service for the **Pizza Ordering System**, built with **Java Spring Boot**. It manages order creation, pizza customisation, state transitions, payment processing, and delivery strategy using object-oriented best practices and software design patterns.

---

## 📌 Features

- 🍕 Pizza builder with base types, sizes, and dynamic toppings
- 🎭 Use of Strategy, State, and Decorator design patterns
- 🚚 Support for delivery and collection methods
- 💳 Simulated payment via Credit Card or PayPal
- 🔁 Order state transitions (Ordered → Preparing → Baking → Delivering → Delivered)
- 📦 RESTful API for frontend interaction

---

## 🧠 Design Patterns Used

| Pattern       | Usage                              |
|---------------|-------------------------------------|
| Strategy      | Payment (CreditCard, PayPal), Delivery (Home, Collection) |
| State         | Order lifecycle management          |
| Decorator     | Dynamic topping composition on pizzas |

---

## 🔧 Technologies

- Java 17
- Spring Boot
- REST Controller
- Lombok (optional)
- Maven

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/mohmed402/pizza-ordering-system.git
cd pizza-ordering-system

Run the code
Application runs at: http://localhost:8080

```
---

## 📁 Project Structure

```bash

src/main/java/com/example/pizza/
├── controller/        # API endpoints
├── model/             # Order entity
├── decorator/         # Pizza base and topping classes
├── state/             # Order state management
├── strategy/          # Payment & Delivery strategies
├── service/           # Core order logic
└── dto/               # Request payloads

```
---

## 🔌 API Endpoints

| Method | Endpoint                    | Description                    |
| ------ | --------------------------- | ------------------------------ |
| POST   | `/api/orders/custom`        | Create a custom pizza order    |
| GET    | `/api/orders/{id}`          | Retrieve order by ID           |
| POST   | `/api/orders/{id}/next`     | Advance to next order state    |
| POST   | `/api/orders/{id}/previous` | Revert to previous order state |
| POST   | `/api/orders/{id}/pay`      | Pay for the order              |

---
## 📄 Example Payload (Create Order)

```bash

{
  "customerName": "Ali",
  "pizzaType": "margherita",
  "pizzaSize": "medium",
  "toppings": ["mushrooms", "pepperoni", "onion"],
  "deliveryMethod": "collection"
}
```

