package com.example.proiectjavacoolapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cool_company")
public class CoolCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;

    private String name;
    private String cui;

    @OneToOne
    @JoinColumn(name = "contact_data_contact_data_id")
    private ContactData contactData;

    @OneToMany(mappedBy = "company")
    private List<Restaurant> restaurantsList = new ArrayList<>();

    public CoolCompany(){}

    public CoolCompany(String name, String cui, ContactData contactData, List<Restaurant> restaurantsList) {
        this.name = name;
        this.cui = cui;
        this.contactData = contactData;
        this.restaurantsList = restaurantsList;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    public List<Restaurant> getRestaurantsList() {
        return restaurantsList;
    }

    public void setRestaurantsList(List<Restaurant> restaurantsList) {
        this.restaurantsList = restaurantsList;
    }
}
