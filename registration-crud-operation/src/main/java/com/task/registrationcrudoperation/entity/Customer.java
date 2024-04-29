package com.task.registrationcrudoperation.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regId;
    private String firstName;
    private String lastName;
    private String emailId;
    private Long phoneNo;
    private String gender;
    private LocalDate dateOfBirth;


    @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn( name = "registration_id", referencedColumnName = "regId")
    private List<Address> address;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "customer_products",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

//    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "customer_categories",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id"))
//    private List<Category> categories;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "customer_order",
//            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "regId"),
//            inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "order_id"))
//    private List<Order> orders = new ArrayList<>();

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_cust_id_ord",referencedColumnName = "regId")
    private  List<CustomerOrder> orders;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="home_id")
//    private List<HomeAddress> homeAddress;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cust_office_id")
//    private List<OfficeAddress> officeAddresses;


    public Customer() {
    }

    public Customer(int regId, String firstName, String lastName, String emailId, Long phoneNo, String gender, LocalDate dateOfBirth, List<Address> address, List<Product> products, List<CustomerOrder> orders) {
        this.regId = regId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.products = products;
        this.orders = orders;
    }

    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<CustomerOrder> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "regId=" + regId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNo=" + phoneNo +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                ", products=" + products +
                ", orders=" + orders +
                '}';
    }
}
