package controllers;

import domain.Expense;
import memento.ExpenseHistory;
import memento.ExpenseMemento;
import memento.OperationEnum;
import strategy.BudgetStrategyContext;

import java.util.List;

public class BudgetController {

    private List<Expense> expenses;

    private BudgetStrategyContext strategyContext;

    private ExpenseHistory expenseHistory;

    public BudgetController(List<Expense> expenses, BudgetStrategyContext strategyContext, ExpenseHistory expenseHistory) {
        this.expenses = expenses;
        this.strategyContext = strategyContext;
        this.expenseHistory = expenseHistory;
        System.out.println("this.expenses.size(): " + this.expenses.size());
    }

    public void addExpense(Expense expense) {
        _addExpense(expense);
        expenseHistory.addMemento(new ExpenseMemento(expense, OperationEnum.ADD));
    }

    public void updateExpense(Expense expense) {
        Expense oldExpense = _updateExpense(expense);
        if (oldExpense != null) {
            ExpenseMemento expenseMemento = new ExpenseMemento(expense, OperationEnum.UPDATE);
            expenseHistory.addMemento(expenseMemento);
            expenseMemento.setOldExpense(oldExpense);
        }


    }

    public void removeExpense(Expense expense) {
        int isRemoved = _removeExpense(expense);
        if (isRemoved == 1) {
            expenseHistory.addMemento(new ExpenseMemento(expense, OperationEnum.REMOVE));
        }
    }

    private void _addExpense(Expense expense) {
        expenses.add(expense);
    }

    private int _removeExpense(Expense expense) {
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getId() == expense.getId()) {
                expenses.remove(expense);
                return 1;
            }
        }
        return 0;
    }

    private Expense _updateExpense(Expense expense) {
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getId() == expense.getId()) {
                Expense oldExpense = expenses.get(i);
                expenses.set(i, expense);
                return oldExpense;
            }
        }
        return null;
    }

    private void _undo(ExpenseMemento expenseMemento) {
        if (expenseMemento.getOperation() == OperationEnum.ADD) {
            _removeExpense(expenseMemento.getExpense());
        } else if (expenseMemento.getOperation() == OperationEnum.REMOVE) {
            _addExpense(expenseMemento.getExpense());
        } else if (expenseMemento.getOperation() == OperationEnum.UPDATE) {
            _updateExpense(expenseMemento.getOldExpense());
        }
    }

    public void undoLast() {
        ExpenseMemento expenseMemento = expenseHistory.getMemento();
        _undo(expenseMemento);
    }

    public void undoByIndex(int index) {
        ExpenseMemento expenseMemento = expenseHistory.getMemento(index);
        if (expenseMemento != null) {
            _undo(expenseMemento);
        } else {
            System.out.println("Couldn't find memento with the selected index.");
        }
    }

    public void analyzeBudget(int month, int year) {
        strategyContext.analyze(expenses, month, year);
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public BudgetStrategyContext getStrategyContext() {
        return strategyContext;
    }

    public void setStrategyContext(BudgetStrategyContext strategyContext) {
        this.strategyContext = strategyContext;
    }

    public ExpenseHistory getExpenseHistory() {
        return expenseHistory;
    }

    public void setExpenseHistory(ExpenseHistory expenseHistory) {
        this.expenseHistory = expenseHistory;
    }
}
