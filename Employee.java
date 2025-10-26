package Cafe;

public abstract class Employee {
    private String name;
    private String position;
    protected double salary;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
        this.salary = 0.0;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract double calculateSalary();
}
