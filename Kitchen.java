package Cafe;

import java.util.ArrayList;
import java.util.List;

public class Kitchen {
  private List<Order> orders = new ArrayList<>();

  public void toCook(Order order) {
    System.out.println("Кухня: получен заказ для " + order.getClient().getName());
    orders.add(order);
    order.setStatus(OrderStatus.IN_WORK);
    // имитация приготовления
    try {
      Thread.sleep(3000); // 3 секунды на приготовление по приколу
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    order.setStatus(OrderStatus.DONE);
    System.out.println("Кухня: заказ для " + order.getClient().getName() + " готов.");
  }

  public List<Order> getOrders() {
    return orders;
  }
}
