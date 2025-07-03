package strategy;

import domain.Expense;
import domain.Purchase;

import java.time.Month;
import java.util.*;

public class BudgetShopStrategy implements BudgetStrategy {

    @Override
    public void analyze(List<Expense> expenses, int month, int year) {
        Map<Integer, Double> map = calculateMonthlyShopExpense(expenses, month, year);
        System.out.println("Shops map.size(): " + map.size());
        Double biedronka = map.get(1);
        Double lidl = map.get(2);
        Double frac = map.get(3);
        Double halfPrice = map.get(4);
        Double pizzeria = map.get(5);

        System.out.println("Sum for biedronka: " + biedronka);
        System.out.println("Sum for lidl: " + lidl);
        System.out.println("Sum for frac: " + frac);
        System.out.println("Sum for halfPrice: " + halfPrice);
        System.out.println("Sum for pizzeria: " + pizzeria);
    }

    private Map<Integer, Double> calculateMonthlyShopExpense(List<Expense> expenses, int month, int year) {
        Map<Integer, Double> monthlyExpenses = new HashMap<>();
        Set<Integer> shopsIds = new HashSet<>();
        for (Expense expense : expenses) {
            if (expense.getClass().equals(Purchase.class)) {
                shopsIds.add(((Purchase) expense).getShopId());
            }
        }
        System.out.println("shopsIds.size(): " + shopsIds.size());

        for (Integer shopId : shopsIds) {
            double total = expenses.stream()
                    .filter(e -> e.getClass().equals(Purchase.class) && ((Purchase) e).getShopId() == shopId.intValue()
                            && ((Purchase) e).getDate().getMonth().equals(Month.of(month)) && ((Purchase) e).getDate().getYear() == year)
                    .mapToDouble(e -> ((Purchase) e).getBillCost())
                    .sum();
            monthlyExpenses.put(shopId, total);
        }
        return monthlyExpenses;
    }
}
