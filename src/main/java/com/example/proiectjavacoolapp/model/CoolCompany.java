package com.example.proiectjavacoolapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cool_company")
public class CoolCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyID;

    private String name;
    private String cui;

    @OneToOne
    @JoinColumn(name = "contact_data_contact_data_id")
    private ContactData contactData;

    @OneToMany
    private List<Restaurant> restaurantsList = new ArrayList<>();
    //0:32 - lab penultimul
    public ContactData getContactData() {
        return contactData;
    }
}
