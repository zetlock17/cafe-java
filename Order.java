package Cafe;

import java.util.List;

public class Order {
  private List<Dish> dishes;
  private Employee waiter;
  private OrderStatus status;
  private Client client;

  public Order(List<Dish> dishes, Employee waiter, Client client) {
    this.dishes = dishes;
    this.waiter = waiter;
    this.client = client;
    this.status = OrderStatus.CREATED;
  }

  public double getTotalPrice() {
    double totalPrice = 0;
    for (Dish dish : dishes) {
      totalPrice += dish.getPrice();
    }
    return totalPrice;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
    System.out.println("Статус заказа изменен на: " + status);
  }

  public OrderStatus getStatus() {
    return status;
  }

  public List<Dish> getDishes() {
    return dishes;
  }

  public Client getClient() {
    return client;
  }

  @Override
  public String toString() {
    return "Заказ для " + client.getName() + ", принят " + waiter.getName() + ", статус: " + status;
  }
}
