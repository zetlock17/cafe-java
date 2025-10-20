package Cafe;

import java.util.ArrayList;
import java.util.List;

public class Dish {
  private String title;
  private String description;
  private double price;
  private int weight;
  private List<Product> products = new ArrayList<>();
  private DishType type;
  private int caloricContent;

  public Dish(String title, String description, double price, int weight, DishType type, int caloricContent) {
    this.title = title;
    this.description = description;
    this.price = price;
    this.weight = weight;
    this.type = type;
    this.caloricContent = caloricContent;
  }

  public void addProduct(Product product) {
    this.products.add(product);
  }

  public String getTitle() {
    return title;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return title + " (" + price + " руб.)";
  }
}
