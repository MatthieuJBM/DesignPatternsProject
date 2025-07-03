package strategy;

import domain.Expense;

import java.util.List;

public class BudgetStrategyContext {

    private BudgetStrategy strategy;

    public BudgetStrategyContext(BudgetStrategy strategy) {
        this.strategy = strategy;
    }

    public BudgetStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(BudgetStrategy strategy) {
        this.strategy = strategy;
    }

    public void analyze(List<Expense> expenses, int month, int year) {
        strategy.analyze(expenses, month, year);
    }
}
