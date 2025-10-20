package Cafe;

import java.util.List;
import java.util.ArrayList;

public class Worker {
  private String name;
  private String position;

  public Worker(String name, String position) {
    this.name = name;
    this.position = position;
  }

  public String getName() {
    return name;
  }

  public Order takeOrder(Client client, List<Dish> dishes, Kitchen kitchen) {
    System.out.println(name + " (" + position + "): принял заказ от " + client.getName());
    Order order = new Order(dishes, this, client);
    toKitchen(order, kitchen);
    return order;
  }

  public void toKitchen(Order order, Kitchen kitchen) {
    System.out.println(name + ": передаю заказ на кухню.");
    order.setStatus(OrderStatus.PENDING);
    kitchen.toCook(order);
  }

  public void getOrderFromKitchen(Order order) {
     if (order.getStatus() == OrderStatus.DONE) {
        System.out.println(name + ": забрал готовый заказ для " + order.getClient().getName() + " с кухни.");
        bringOrderToClient(order);
     } else {
        System.out.println(name + ": заказ для " + order.getClient().getName() + " еще не готов.");
     }
  }

  private void bringOrderToClient(Order order) {
      System.out.println(name + ": вот ваш заказ, " + order.getClient().getName() + ".");
      System.out.print("Блюда: ");
      order.getDishes().forEach(dish -> System.out.print(dish.getTitle() + "; "));
      System.out.println("\nК оплате: " + order.getTotalPrice() + " руб.");
  }
}
