package com.example.proiectjavacoolapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurantId;
    @NotBlank(message = "We need a name! ")
    private String name;

    @OneToOne
    @JoinColumn(name = "menu_menu_id")
    private Menu menu;

    @OneToOne
    @JoinColumn(name = "contact_data_contact_data_id")
    private ContactData contactData;

    @OneToMany(mappedBy = "restaurant")
    @JsonIgnore
    private List<Employee> employees = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private CoolCompany company;

    public Restaurant(){}

    public Restaurant(String name, Menu menu, ContactData contactData, List<Employee> employees) {
        this.name = name;
        this.menu = menu;
        this.contactData = contactData;
        this.employees = employees;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public CoolCompany getCompany() {
        return company;
    }

    public void setCompany(CoolCompany company) {
        this.company = company;
    }
}
