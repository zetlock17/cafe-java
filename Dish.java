package Cafe;

public class Dish implements Discountable {
  private String title;
  private String description;
  private double price;
  private int weight;
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

  @Override
  public double getDiscountedPrice(double discountRate) {
    if (discountRate < 0) {
        discountRate = 0;
    }
    if (discountRate > 1) {
        discountRate = 1;
    }
    return price * (1 - discountRate);
  }
}
