package Cafe;

import java.util.ArrayList;
import java.util.List;

public class Kitchen {
  private List<Order> orders = new ArrayList<>();
  private List<Chef> chefs = new ArrayList<>();

  public void addChef(Chef chef) {
    chefs.add(chef);
  }

  public void toCook(Order order) {
    System.out.println("Кухня: получен заказ для " + order.getClient().getName());
    orders.add(order);
    if (!chefs.isEmpty()) {
      Chef chef = chefs.get(0);
      chef.cookOrder(order);
    } else {
      System.out.println("Кухня: нет поваров!");
    }
  }

  public List<Order> getOrders() {
    return orders;
  }
}
