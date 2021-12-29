package com.example.proiectjavacoolapp.model;

import javax.persistence.*;

@Entity
@Table(name = "contact_data")
public class ContactData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactDataId;
    private String phoneNumber;
    private String adress;
    private String website;

    public ContactData(){
    }

    public ContactData(String phoneNumber, String adress, String website) {
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.website = website;
    }

    public int getContactDataId() {
        return contactDataId;
    }

    public void setContactDataId(int contactDataId) {
        this.contactDataId = contactDataId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
