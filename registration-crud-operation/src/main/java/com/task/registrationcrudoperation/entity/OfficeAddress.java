package com.task.registrationcrudoperation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OfficeAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int office_id;
    private Long pinCode;
    private String city;
    private String state;

    public OfficeAddress() {
    }

    public OfficeAddress(int office_id, Long pinCode, String city, String state) {
        this.office_id = office_id;
        this.pinCode = pinCode;
        this.city = city;
        this.state = state;
    }

    public int getOffice_id() {
        return office_id;
    }

    public void setOffice_id(int office_id) {
        this.office_id = office_id;
    }

    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
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

    @Override
    public String toString() {
        return "OfficeAddress{" +
                "office_id=" + office_id +
                ", pinCode=" + pinCode +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
