package Cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Cafe cafe = new Cafe(10);
    cafe.openCafe();

    Worker waiter = new Worker("Анна", "Официант");
    cafe.addWorker(waiter);

    Menu menu = cafe.getMenu();
    Dish soup = new Dish("Суп", "Вкусный супчик", 250.0, 300, DishType.MAIN, 200);
    Dish rise = new Dish("Сайрис", "Рис с сайрой", 350.0, 300, DishType.MAIN, 250);
    Dish steak = new Dish("Стейк", "Стейк из мумушки", 1200.0, 250, DishType.MAIN, 600);
    Dish dessert = new Dish("Сладкая нямка", "капэц вкусная реально", 400.0, 150, DishType.DESSERT, 450);
    Dish coffee = new Dish("Кофе", "Кофе из попки слоника", 150.0, 200, DishType.DRINK, 100);
    menu.addDish(soup);
    menu.addDish(rise);
    menu.addDish(steak);
    menu.addDish(dessert);
    menu.addDish(coffee);

    Client client = new Client("Лёшка");
    cafe.clientArrived(client);

    Scanner scanner = new Scanner(System.in);

    for (int orderCount = 1; orderCount <= 5; orderCount++) { // orderCount <= 5 для того чтобы после 5 заказов кафе закрылось
        System.out.println("\n--- Заказ #" + orderCount + " ---");

        System.out.println("\n" + waiter.getName() + ": " + client.getName() + ", чо хочешь йоу?");
        menu.printMenu();
        
        List<Dish> chosenDishes = new ArrayList<>();
        System.out.println("Введите номера блюд для заказа через пробел (например, 1 3):");
        String[] choices = scanner.nextLine().split(" ");
        for (String choice : choices) {
            try {
                int dishIndex = Integer.parseInt(choice) - 1;
                if (dishIndex >= 0 && dishIndex < menu.getDishes().size()) {
                    chosenDishes.add(menu.getDishes().get(dishIndex));
                }
            } catch (NumberFormatException e) {
                // игнорируем некорректный ввод
            }
        }

        if (chosenDishes.isEmpty()) {
            System.out.println("Вы ничего не выбрали в этот раз.");
            continue; // пропускаем итерацию, если заказ пуст
        }

        Order order = waiter.takeOrder(client, chosenDishes, cafe.getKitchen());

        while(order.getStatus() != OrderStatus.DONE) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        waiter.getOrderFromKitchen(order);

        client.payOrder(order);
    }

    scanner.close();

    cafe.clientLeft(client);
    
    cafe.closeCafe();
  }
}
