package Cafe;

import java.util.List;

public class Client {
  private String name;

  public Client(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void payOrder(Order order) {
    System.out.println(name + " оплатил(а) заказ на сумму " + order.getTotalPrice() + " руб.");
  }

  @Override
  public String toString() {
    return "Клиент: " + name;
  }
}
