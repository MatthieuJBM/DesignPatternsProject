package domain;

import java.time.LocalDate;

public class Purchase implements Expense {

    private int id;
    private double billCost;

    private int categoryId;

    private LocalDate date;

    private String note;

    private int shopId;

    private int subcategoryId;

    public Purchase(int id, double billCost, int categoryId, LocalDate date, String note, int shopId, int subcategoryId) {
        this.id = id;
        this.billCost = billCost;
        this.categoryId = categoryId;
        this.date = date;
        this.note = note;
        this.shopId = shopId;
        this.subcategoryId = subcategoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBillCost() {
        return billCost;
    }

    public void setBillCost(double billCost) {
        this.billCost = billCost;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public double getCost() {
        return billCost;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }
}
