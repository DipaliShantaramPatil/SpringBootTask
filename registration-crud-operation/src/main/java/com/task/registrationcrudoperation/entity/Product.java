package com.task.registrationcrudoperation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String name;
    private String description;
    private double price;
//    @Lob
//    private byte[] image;
//    @Lob
//    private byte[] image1;
//    @Lob
//    private byte[] image2;

    private String image;
    private String image1;
    private String image2;

//    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinTable(name="product_category",
//            joinColumns=@JoinColumn(name = "product_id",referencedColumnName = "product_id"),
//            inverseJoinColumns=@JoinColumn(name="category_id",referencedColumnName = "category_id"))
//    private List<Category> categories=new ArrayList<>();
//
//    @JsonIgnore
//    @ManyToMany(mappedBy = "products",fetch = FetchType.LAZY)
//    private List<Customer> customers;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_prod_id",referencedColumnName = "product_id")
    private List<Category> categories;

    public Product() {
    }

    public Product(int product_id, String name, String description, double price, String image, String image1, String image2, List<Category> categories) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.categories = categories;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                ", categories=" + categories +
                '}';
    }
}
