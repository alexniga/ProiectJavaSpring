package com.example.proiectjavacoolapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuId;

    @ManyToMany
    @JoinTable(name = "menu_cooked_food", joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "cooked_food_id"))
    private List<CookedFood> cookedFoodList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "menu_drinks", joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "drink_id"))
    private List<Drink> drinkList = new ArrayList<>();

    public Menu(){}

    public Menu(List<CookedFood> cookedFoodList, List<Drink> drinkList) {
        this.menuId = menuId;
        this.cookedFoodList = cookedFoodList;
        this.drinkList = drinkList;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public List<CookedFood> getCookedFoodList() {
        return cookedFoodList;
    }

    public void setCookedFoodList(List<CookedFood> cookedFoodList) {
        this.cookedFoodList = cookedFoodList;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }
}
