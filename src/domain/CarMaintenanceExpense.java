package domain;

import java.time.LocalDate;

public class CarMaintenanceExpense implements Expense {

    private int id;
    private double cost;

    private LocalDate date;

    private String description;

    private String type;

    public CarMaintenanceExpense(int id, double cost, LocalDate date, String description, String type) {
        this.id = id;
        this.cost = cost;
        this.date = date;
        this.description = description;
        this.type = type;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
