package Cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
  private Kitchen kitchen;
  private Menu menu;
  private List<Worker> workers;
  private List<Client> clients;
  private int maxCapacity;
  private boolean open;

  public Cafe(int maxCapacity) {
    this.maxCapacity = maxCapacity;
    this.kitchen = new Kitchen();
    this.menu = new Menu();
    this.workers = new ArrayList<>();
    this.clients = new ArrayList<>();
    this.open = false;
  }

  public void openCafe() {
    this.open = true;
    System.out.println("Кафе открыто!");
  }

  public void closeCafe() {
    this.open = false;
    System.out.println("Кафе закрыто.");
  }
  
  public void addWorker(Worker worker) {
      workers.add(worker);
  }

  public void clientArrived(Client client) {
      if (clients.size() < maxCapacity) {
          clients.add(client);
          System.out.println("Новый клиент в кафе: " + client.getName());
      } else {
          System.out.println("Извините, " + client.getName() + ", в кафе нет свободных мест.");
      }
  }

  public void clientLeft(Client client) {
      clients.remove(client);
      System.out.println("Клиент " + client.getName() + " ушел.");
  }

  public Menu getMenu() {
      return menu;
  }

  public Kitchen getKitchen() {
      return kitchen;
  }

  public List<Worker> getWorkers() {
      return workers;
  }
}
