package com.example.proiectjavacoolapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drink")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int drinkId;
    @NotBlank(message = "We need a name")
    private String name;
    @NotNull(message = "We need to ahve a price")
    private int price;
    @NotNull(message = "WE NEED QUANTITY!")
    @Min(value = 50)
    private int quantity;


    @ManyToMany(mappedBy = "drinkList")
    @JsonIgnore
    private List<Menu> menu = new ArrayList<>();

    public Drink(){}

    public Drink(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }
}
