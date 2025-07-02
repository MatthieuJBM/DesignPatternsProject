package domain;

import java.time.LocalDate;

public class FuelExpense implements Expense {
    private int id;

    private LocalDate date;

    private double fuelAmount;

    private String fuelType;

    private int odometerReading;

    private String petrolStationName;

    private double price;

    private double pricePerUnit;

    public FuelExpense(int id, LocalDate date, double fuelAmount, String fuelType, int odometerReading, String petrolStationName, double price, double pricePerUnit) {
        this.id = id;
        this.date = date;
        this.fuelAmount = fuelAmount;
        this.fuelType = fuelType;
        this.odometerReading = odometerReading;
        this.petrolStationName = petrolStationName;
        this.price = price;
        this.pricePerUnit = pricePerUnit;
    }


    @Override
    public double getCost() {
        return price;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }

    public String getPetrolStationName() {
        return petrolStationName;
    }

    public void setPetrolStationName(String petrolStationName) {
        this.petrolStationName = petrolStationName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
