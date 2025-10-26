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
        order.setStatus(OrderStatus.DONE);
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
