package strategy;

import domain.Expense;

import java.util.List;

public interface BudgetStrategy {

    void analyze(List<Expense> expenses, int month, int year);

}
