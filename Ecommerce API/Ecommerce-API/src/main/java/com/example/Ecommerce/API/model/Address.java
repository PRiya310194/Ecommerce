package com.example.Ecommerce.API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tbl_Address")
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "address_id")
    private Integer addressId;
    @Column(name = "address_name")
    private String name;
    @Column(name = "address_landmark")
    private String landmark;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address_zipcode")
    private String zipcode;
    @Column(name = "state")
    private String state;
    @JoinColumn(name = "user_id")
    @OneToOne
    private User userId;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getUser() {
        return userId;
    }

    public void setUser(Integer user) {
        this.userId = userId;
    }
}
