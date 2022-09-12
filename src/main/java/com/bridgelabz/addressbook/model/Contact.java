package com.bridgelabz.addressbook.model;


import com.bridgelabz.addressbook.dto.ContactDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String city;
    private String state;
    private String address;
    @ElementCollection
    @CollectionTable(name="phoneNumber",joinColumns = @JoinColumn(name = "id"))
    private List<String> phoneNumber;
    private int zipCode;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact(int id, String name, String city, String state, String address, List<String> phoneNumber, int zipCode, String email) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
        this.email = email;
    }
    public Contact()
    {

    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", zipCode=" + zipCode +
                ", email='" + email + '\'' +
                '}';
    }
    public Contact(ContactDTO contactDTO)
    {
        this.name = contactDTO.getName();
        this.city = contactDTO.getCity();
        this.state = contactDTO.getState();
        this.address = contactDTO.getAddress();
        this.phoneNumber = contactDTO.getPhoneNumber();
        this.email = contactDTO.getEmail();
    }
}
