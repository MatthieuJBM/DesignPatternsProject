package strategy;

import domain.Category;
import domain.Expense;
import domain.Purchase;

import java.time.Month;
import java.util.*;

public class BudgetCategoryStrategy implements BudgetStrategy {
    @Override
    public void analyze(List<Expense> expenses, int month, int year) {
        Map<Integer, Double> map = calculateMonthlyCategoryExpense(expenses, month, year);
        System.out.println("categories map.size(): " + map.size());
        Double grocery = map.get(1);
        Double clothes = map.get(2);
        Double eatingOutside = map.get(3);

        System.out.println("Sum for grocery: " + grocery);
        System.out.println("Sum for clothes: " + clothes);
        System.out.println("Sum for eating outside: " + eatingOutside);

    }


    // The method return a Map<Integer, Double>, where Integer corresponds to id of a category
    // and Double corresponds to sum of values of expenses for a certain category.
    // The user can then restore the name of a category using its id.
    private Map<Integer, Double> calculateMonthlyCategoryExpense(List<Expense> expenses, int month, int year) {
        Map<Integer, Double> monthlyExpenses = new HashMap<>();
        Set<Integer> categoriesIds = new HashSet<>();
        for (Expense expense : expenses) {
            if (expense.getClass().equals(Purchase.class)) {
                categoriesIds.add(((Purchase) expense).getCategoryId());
            }
        }
        System.out.println("categoriesIds.size(): " + categoriesIds.size());

        for (Integer categoryId : categoriesIds) {
            double total = expenses.stream()
                    .filter(e -> e.getClass().equals(Purchase.class) && ((Purchase) e).getCategoryId() == categoryId.intValue()
                            && ((Purchase) e).getDate().getMonth().equals(Month.of(month)) && ((Purchase) e).getDate().getYear() == year)
                    .mapToDouble(e -> ((Purchase) e).getBillCost())
                    .sum();
            monthlyExpenses.put(categoryId, total);
        }
        return monthlyExpenses;
    }
}
