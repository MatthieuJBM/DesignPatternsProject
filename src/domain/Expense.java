package domain;

import java.time.LocalDate;

public interface Expense {
    public int getId();

    public double getCost();

    public LocalDate getDate();



}
