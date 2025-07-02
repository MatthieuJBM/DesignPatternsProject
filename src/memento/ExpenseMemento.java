package memento;

import domain.Expense;

public class ExpenseMemento {

    private Expense expense;

    public ExpenseMemento(Expense expense) {
        this.expense = expense;
    }

    public Expense getExpense() {
        return this.expense;
    }
}
