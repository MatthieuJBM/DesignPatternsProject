package strategy;

import domain.Expense;
import domain.Purchase;

import java.time.Month;
import java.util.*;

public class BudgetSubcategoryStrategy implements BudgetStrategy {

    @Override
    public void analyze(List<Expense> expenses, int month, int year) {
        Map<Integer, Double> map = calculateMonthlySubcategoryExpense(expenses, month, year);
        System.out.println("map.size(): " + map.size());
    }

    public Map<Integer, Double> calculateMonthlySubcategoryExpense(List<Expense> expenses, int month, int year) {
        Map<Integer, Double> monthlyExpenses = new HashMap<>();
        Set<Integer> subcategoriesIds = new HashSet<>();
        for (Expense expense : expenses) {
            if (expense.getClass().equals(Purchase.class)) {
                subcategoriesIds.add(((Purchase) expense).getSubcategoryId());
            }
        }
        System.out.println("subcategoriesIds.size(): " + subcategoriesIds.size());

        for (Integer subcategoryId : subcategoriesIds) {
            double total = expenses.stream()
                    .filter(e -> e.getClass().equals(Purchase.class) && ((Purchase) e).getSubcategoryId() == subcategoryId.intValue()
                            && ((Purchase) e).getDate().getMonth().equals(Month.of(month)) && ((Purchase) e).getDate().getYear() == year)
                    .mapToDouble(e -> ((Purchase) e).getBillCost())
                    .sum();
            monthlyExpenses.put(subcategoryId, total);
        }
        return monthlyExpenses;
    }
}
