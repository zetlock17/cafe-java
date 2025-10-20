package Cafe;

import java.util.ArrayList;
import java.util.List;

public class Menu {
  private List<Dish> dishes = new ArrayList<>();

  public void addDish(Dish dish) {
    this.dishes.add(dish);
  }

  public List<Dish> getDishes() {
    return dishes;
  }

  public void printMenu() {
    System.out.println("----- МЕНЮ -----");
    for (int i = 0; i < dishes.size(); i++) {
      System.out.println((i + 1) + ". " + dishes.get(i));
    }
    System.out.println("----------------");
  }
}
