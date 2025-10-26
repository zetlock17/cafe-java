package Cafe;

import java.util.List;

public class Waiter extends Employee {
    private double baseSalary;
    private double totalSales; 

    public Waiter(String name, double baseSalary) {
        super(name, "Официант");
        this.baseSalary = baseSalary;
        this.totalSales = 0.0;
    }

    public Order takeOrder(Client client, List<Dish> dishes, Kitchen kitchen) {
        System.out.println(getName() + " (" + getPosition() + "): принял заказ от " + client.getName());
        Order order = new Order(dishes, this, client);
        toKitchen(order, kitchen);
        return order;
    }

    public void toKitchen(Order order, Kitchen kitchen) {
        System.out.println(getName() + ": передаю заказ на кухню.");
        order.setStatus(OrderStatus.PENDING);
        kitchen.toCook(order);
    }

    public void getOrderFromKitchen(Order order) {
       if (order.getStatus() == OrderStatus.DONE) {
          System.out.println(getName() + ": забрал готовый заказ для " + order.getClient().getName() + " с кухни.");
          bringOrderToClient(order);
       } else {
          System.out.println(getName() + ": заказ для " + order.getClient().getName() + " еще не готов.");
       }
    }

    private void bringOrderToClient(Order order) {
        System.out.println(getName() + ": вот ваш заказ, " + order.getClient().getName() + ".");
        System.out.print("Блюда: ");
        order.getDishes().forEach(dish -> System.out.print(dish.getTitle() + "; "));
        System.out.println("\nК оплате: " + order.getTotalPrice() + " руб.");
        totalSales += order.getTotalPrice();
    }

    @Override
    public double calculateSalary() {
        double calculatedSalary = baseSalary + 0.05 * totalSales;
        setSalary(calculatedSalary);
        return calculatedSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getTotalSales() {
        return totalSales;
    }
}
