package domain;

import java.util.List;

public class Subcategory extends Category {

    public Subcategory(int id, String color, String icon, String name, List<Integer> subcategoriesIds) {
        super(id, color, icon, name, subcategoriesIds);
    }
}
