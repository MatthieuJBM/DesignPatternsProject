package domain;

import java.time.LocalDate;

public class HomeExpense implements Expense {

    private int id;

    private double cost;

    private LocalDate date;

    private String type;

    public HomeExpense(int id, double cost, LocalDate date, String type) {
        this.id = id;
        this.cost = cost;
        this.date = date;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
