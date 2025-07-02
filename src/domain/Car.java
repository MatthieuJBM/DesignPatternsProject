package domain;

import java.util.List;

public class Car {

    private int id;
    private String engineType;

    private List<Integer> fuelExpensesIds;

    private List<Integer> maintenanceExpensesIds;

    private String model;

    private String name;

    public Car(int id, String engineType, List<Integer> fuelExpensesIds, List<Integer> maintenanceExpensesIds, String model, String name) {
        this.id = id;
        this.engineType = engineType;
        this.fuelExpensesIds = fuelExpensesIds;
        this.maintenanceExpensesIds = maintenanceExpensesIds;
        this.model = model;
        this.name = name;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public List<Integer> getFuelExpensesIds() {
        return fuelExpensesIds;
    }

    public void setFuelExpensesIds(List<Integer> fuelExpensesIds) {
        this.fuelExpensesIds = fuelExpensesIds;
    }

    public List<Integer> getMaintenanceExpensesIds() {
        return maintenanceExpensesIds;
    }

    public void setMaintenanceExpensesIds(List<Integer> maintenanceExpensesIds) {
        this.maintenanceExpensesIds = maintenanceExpensesIds;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
