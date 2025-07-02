package domain;

import java.util.List;

public class Category {

    private int id;
    private String color;

    private String icon;

    private String name;

    private List<Integer> subcategoriesIds;

    public Category(int id, String color, String icon, String name, List<Integer> subcategoriesIds) {
        this.id = id;
        this.color = color;
        this.icon = icon;
        this.name = name;
        this.subcategoriesIds = subcategoriesIds;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getSubcategoriesIds() {
        return subcategoriesIds;
    }

    public void setSubcategoriesIds(List<Integer> subcategoriesIds) {
        this.subcategoriesIds = subcategoriesIds;
    }
}
