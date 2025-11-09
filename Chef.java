package Cafe;

public class Chef extends Employee {
    private String specialty;
    private double fixedSalary;

    public Chef(String name, String specialty, double fixedSalary) {
        super(name, "Повар");
        this.specialty = specialty;
        this.fixedSalary = fixedSalary;
    }

    public void cookOrder(Order order) {
        System.out.println(getName() + ": готовит заказ для " + order.getClient().getName() + ".");
        order.setStatus(OrderStatus.IN_WORK);
        // имитация приготовления
        try {
            Thread.sleep(3000); // 3 секунды на приготовление
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        order.setStatus(OrderStatus.DONE);
        System.out.println(getName() + ": заказ для " + order.getClient().getName() + " готов.");
    }

    @Override
    public double calculateSalary() {
        setSalary(fixedSalary);
        return fixedSalary;
    }

    public String getSpecialty() {
        return specialty;
    }
}
