package strategy;

import domain.Expense;
import domain.Purchase;

import java.time.Month;
import java.util.*;

public class BudgetMonthlySummaryStrategy implements BudgetStrategy {

    @Override
    public void analyze(List<Expense> expenses, int month, int year) {
        Double entireCost = calculateMonthlySummaryExpense(expenses, month, year);
        System.out.println("entireCost: " + entireCost);
    }

    private Double calculateMonthlySummaryExpense(List<Expense> expenses, int month, int year) {
        double total = 0;
        for (Expense expense : expenses) {
            if (expense.getDate().getMonth().equals(Month.of(month)) && expense.getDate().getYear() == year) {
                total += expense.getCost();
            }
        }
        return total;
    }
}
