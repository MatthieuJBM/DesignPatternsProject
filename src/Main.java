import controllers.BudgetController;
import domain.*;
import memento.ExpenseHistory;
import strategy.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Project Memento & Strategy!");

        List<Expense> expenses = new ArrayList<>();
        ExpenseHistory expenseHistory = new ExpenseHistory();

        BudgetStrategy budgetCategoryStrategy = new BudgetCategoryStrategy();
        BudgetStrategy budgetSubcategoryStrategy = new BudgetSubcategoryStrategy();
        BudgetStrategy budgetShopStrategy = new BudgetShopStrategy();
        BudgetStrategy budgetMonthlySummaryStrategy = new BudgetMonthlySummaryStrategy();

        BudgetStrategyContext strategyContextCategory = new BudgetStrategyContext(budgetCategoryStrategy);
        BudgetStrategyContext strategyContextSubcategory = new BudgetStrategyContext(budgetSubcategoryStrategy);
        BudgetStrategyContext strategyContextShop = new BudgetStrategyContext(budgetShopStrategy);
        BudgetStrategyContext strategyContextMonthlySummary = new BudgetStrategyContext(budgetMonthlySummaryStrategy);

        // BudgetCategoryStrategy passed
        BudgetController budgetController = new BudgetController(expenses, strategyContextCategory, expenseHistory);


        //HomeExpenses
        HomeExpense homeExpense1 = new HomeExpense(1, 438, LocalDate.now(), "Wywoz smieci");
        HomeExpense homeExpense2 = new HomeExpense(2, 438, LocalDate.of(2025, 4, 10), "Wywoz smieci");
        HomeExpense homeExpense3 = new HomeExpense(3, 69.90, LocalDate.now(), "Internet");
        HomeExpense homeExpense4 = new HomeExpense(4, 1000, LocalDate.now(), "Czynsz");
        HomeExpense homeExpense5 = new HomeExpense(5, 300, LocalDate.now(), "Woda");
        HomeExpense homeExpense6 = new HomeExpense(6, 400, LocalDate.now(), "Prad");
        HomeExpense homeExpense7 = new HomeExpense(7, 69.90, LocalDate.of(2025, 6, 10), "Internet");
        HomeExpense homeExpense8 = new HomeExpense(8, 1000, LocalDate.of(2025, 6, 10), "Czynsz");
        HomeExpense homeExpense9 = new HomeExpense(9, 300, LocalDate.of(2025, 5, 10), "Woda");
        HomeExpense homeExpense10 = new HomeExpense(10, 400, LocalDate.of(2025, 4, 10), "Prad");

        //FuelExpenses
        FuelExpense fuelExpense1 = new FuelExpense(1, LocalDate.of(2025, 5, 5), 33.35, "LPG", 2000, "Orlen", 100.05, 3.00);
        FuelExpense fuelExpense2 = new FuelExpense(2, LocalDate.of(2025, 5, 10), 33.35, "LPG", 2300, "Orlen", 100.05, 3.00);
        FuelExpense fuelExpense3 = new FuelExpense(3, LocalDate.of(2025, 5, 15), 33.35, "LPG", 2600, "Orlen", 100.05, 3.00);
        FuelExpense fuelExpense4 = new FuelExpense(4, LocalDate.of(2025, 5, 20), 33.35, "LPG", 2900, "Orlen", 100.05, 3.00);
        FuelExpense fuelExpense5 = new FuelExpense(5, LocalDate.of(2025, 5, 25), 33.35, "LPG", 3200, "Orlen", 100.05, 3.00);
        FuelExpense fuelExpense6 = new FuelExpense(6, LocalDate.of(2025, 5, 30), 33.35, "LPG", 3500, "Orlen", 100.05, 3.00);
        FuelExpense fuelExpense7 = new FuelExpense(7, LocalDate.of(2025, 6, 10), 33.35, "LPG", 3800, "Orlen", 100.05, 3.00);
        FuelExpense fuelExpense8 = new FuelExpense(8, LocalDate.of(2025, 6, 20), 33.35, "LPG", 4100, "Orlen", 100.05, 3.00);
        FuelExpense fuelExpense9 = new FuelExpense(9, LocalDate.of(2025, 6, 30), 33.35, "LPG", 4400, "Orlen", 100.05, 3.00);
        FuelExpense fuelExpense10 = new FuelExpense(10, LocalDate.now(), 33.35, "LPG", 4700, "Orlen", 100.05, 3.00);

        //CarMaintenanceExpenses
        CarMaintenanceExpense carMaintenanceExpense1 = new CarMaintenanceExpense(1, 400, LocalDate.now(), "Wachacz przedni prawy", "Naprawa");
        CarMaintenanceExpense carMaintenanceExpense2 = new CarMaintenanceExpense(2, 180.35, LocalDate.now(), "Lozysko przednie lewe", "Naprawa");
        CarMaintenanceExpense carMaintenanceExpense3 = new CarMaintenanceExpense(3, 180.35, LocalDate.now(), "Lozysko przednie lewe", "Naprawa");
        CarMaintenanceExpense carMaintenanceExpense4 = new CarMaintenanceExpense(4, 800, LocalDate.now(), "Ubezpieczenie", "OC");
        CarMaintenanceExpense carMaintenanceExpense5 = new CarMaintenanceExpense(5, 150, LocalDate.now(), "Serwis LPG", "Serwis");
        CarMaintenanceExpense carMaintenanceExpense6 = new CarMaintenanceExpense(6, 200, LocalDate.now(), "Wymiana opon", "Serwis");
        CarMaintenanceExpense carMaintenanceExpense7 = new CarMaintenanceExpense(7, 162, LocalDate.now(), "Badanie techniczne", "Serwis");
        CarMaintenanceExpense carMaintenanceExpense8 = new CarMaintenanceExpense(8, 3, LocalDate.now(), "", "Myjnia");

        //Categories
        Category category1 = new Category(1, "#FF253244", "14235", "Grocery", new ArrayList<>());
        Category category2 = new Category(2, "#FF253244", "14235", "Clothes", new ArrayList<>());
        Category category3 = new Category(3, "#FF253244", "14235", "Eating outside", new ArrayList<>());

        List<Category> categories = new ArrayList<>();
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        //Shops
        Shop shop1 = new Shop(1, "Biedronka");
        Shop shop2 = new Shop(2, "Lidl");
        Shop shop3 = new Shop(3, "Frac");
        Shop shop4 = new Shop(4, "HalfPrice");
        Shop shop5 = new Shop(5, "Pizzeria");

        List<Shop> shops = new ArrayList<>();
        shops.add(shop1);
        shops.add(shop2);
        shops.add(shop3);
        shops.add(shop4);
        shops.add(shop5);

        //Purchases
        Purchase purchase1 = new Purchase(1, 122.50, 1, LocalDate.now(), "", 1, 0);
        Purchase purchase2 = new Purchase(2, 34.80, 1, LocalDate.now(), "Chusteczki", 1, 0);
        Purchase purchase3 = new Purchase(3, 155.30, 1, LocalDate.now(), "", 1, 0);
        Purchase purchase4 = new Purchase(4, 300.50, 1, LocalDate.now(), "Owoce", 2, 0);
        Purchase purchase5 = new Purchase(5, 140.50, 1, LocalDate.now(), "Mieso", 3, 0);
        Purchase purchase6 = new Purchase(6, 500, 2, LocalDate.now(), "", 4, 0);
        Purchase purchase7 = new Purchase(7, 119.99, 2, LocalDate.now(), "", 4, 0);
        Purchase purchase8 = new Purchase(8, 55.50, 1, LocalDate.now(), "", 1, 0);
        Purchase purchase9 = new Purchase(9, 32.50, 3, LocalDate.now(), "", 5, 0);
        Purchase purchase10 = new Purchase(10, 44.50, 3, LocalDate.now(), "", 5, 0);

        // Checking whether Memento works well.
        budgetController.addExpense(purchase1);
        budgetController.addExpense(purchase2);
        budgetController.addExpense(purchase3);
        System.out.println("budgetController.getExpenses().size() after adding 3: " + budgetController.getExpenses().size());
        budgetController.undoLast();
        budgetController.removeExpense(purchase2);
        System.out.println("budgetController.getExpenses().size() after removing position 2: " + budgetController.getExpenses().size());
        budgetController.undoLast();
        System.out.println("budgetController.getExpenses().size() after undoLast: " + budgetController.getExpenses().size());

        budgetController.addExpense(purchase4);
        budgetController.addExpense(purchase5);
        budgetController.addExpense(purchase6);
        budgetController.addExpense(purchase7);
        budgetController.addExpense(purchase8);
        budgetController.addExpense(purchase9);
        budgetController.addExpense(purchase10);

        // Adding home expenses.
        budgetController.addExpense(homeExpense1);
        budgetController.addExpense(homeExpense2);
        budgetController.addExpense(homeExpense3);
        budgetController.addExpense(homeExpense4);
        budgetController.addExpense(homeExpense5);
        budgetController.addExpense(homeExpense6);
        budgetController.addExpense(homeExpense7);
        budgetController.addExpense(homeExpense8);
        budgetController.addExpense(homeExpense9);
        budgetController.addExpense(homeExpense10);
        // Adding fuel expenses.
        budgetController.addExpense(fuelExpense1);
        budgetController.addExpense(fuelExpense2);
        budgetController.addExpense(fuelExpense3);
        budgetController.addExpense(fuelExpense4);
        budgetController.addExpense(fuelExpense5);
        budgetController.addExpense(fuelExpense6);
        budgetController.addExpense(fuelExpense7);
        budgetController.addExpense(fuelExpense8);
        budgetController.addExpense(fuelExpense9);
        budgetController.addExpense(fuelExpense10);
        // Adding car maintenane expenses
        budgetController.addExpense(carMaintenanceExpense1);
        budgetController.addExpense(carMaintenanceExpense2);
        budgetController.addExpense(carMaintenanceExpense3);
        budgetController.addExpense(carMaintenanceExpense4);
        budgetController.addExpense(carMaintenanceExpense5);
        budgetController.addExpense(carMaintenanceExpense6);
        budgetController.addExpense(carMaintenanceExpense7);
        budgetController.addExpense(carMaintenanceExpense8);

        System.out.println("budgetController.getExpenses().size() after adding all the expenses: " + budgetController.getExpenses().size());


        budgetController.analyzeBudget(7, 2025);

        // BudgetSubcategoryStrategy set
        budgetController.setStrategyContext(strategyContextSubcategory);
        // BudgetShopStrategy set
        budgetController.setStrategyContext(strategyContextShop);
        budgetController.analyzeBudget(7, 2025);

        // BudgetMonthlySummaryStrategy set
        budgetController.setStrategyContext(strategyContextMonthlySummary);
        budgetController.analyzeBudget(7, 2025);

    }
}