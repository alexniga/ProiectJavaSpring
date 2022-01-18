package com.example.proiectjavacoolapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table()
public class CookedFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cookedFoodId;
    @NotBlank(message = "We need a name")
    private String name;
    @NotNull(message = "Price has to be not null")
    private int price;
    @NotBlank(message = "WE NEED INGREDIENTS")
    private String ingredients;

    @ManyToMany(mappedBy = "cookedFoodList")
    @JsonIgnore
    private List<Menu> menu = new ArrayList<>();

    public CookedFood(){}

    public CookedFood(String name, int price, String ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public int getCookedFoodId() {
        return cookedFoodId;
    }

    public void setCookedFoodId(int cookedFoodId) {
        this.cookedFoodId = cookedFoodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

}
