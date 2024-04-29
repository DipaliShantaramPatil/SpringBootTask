package com.task.registrationcrudoperation.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_Id;
    private String name;
    private double price;
    private int quantity;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
//    private List<Customer> customers ;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="home_id")
    private List<HomeAddress> homeAddress;

    public CustomerOrder() {
    }

    public CustomerOrder(int order_Id, String name, double price, int quantity, List<HomeAddress> homeAddress) {
        this.order_Id = order_Id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.homeAddress = homeAddress;
    }

    public int getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(int order_Id) {
        this.order_Id = order_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<HomeAddress> getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(List<HomeAddress> homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "order_Id=" + order_Id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", homeAddress=" + homeAddress +
                '}';
    }
}
