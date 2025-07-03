package memento;

import domain.Expense;

public class ExpenseMemento {

    private Expense expense;

    private OperationEnum operation;

    // Used in case of updating an expense.
    private Expense oldExpense;

    public ExpenseMemento(Expense expense, OperationEnum operation) {
        this.expense = expense;
        this.operation = operation;
    }

    public Expense getExpense() {
        return this.expense;
    }

    public OperationEnum getOperation() {
        return operation;
    }

    public Expense getOldExpense() {
        return oldExpense;
    }

    public void setOldExpense(Expense oldExpense) {
        this.oldExpense = oldExpense;
    }
}
