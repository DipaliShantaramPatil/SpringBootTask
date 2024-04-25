package com.task.registrationcrudoperation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    private String name;
    private String description;
//
    @JsonIgnore
    @ManyToMany(mappedBy = "categories",fetch = FetchType.LAZY)
    private List<Product> products;

//    @ManyToMany(mappedBy = "categories",fetch = FetchType.LAZY)
//    private List<Customer> customers;


    public Category() {
    }

    public Category(int categoryId, String name, String description, List<Product> products) {
        this.category_id = categoryId;
        this.name = name;
        this.description = description;
        this.products = products;
    }

    public int getCategoryId() {
        return category_id;
    }

    public void setCategoryId(int categoryId) {
        this.category_id = categoryId;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + category_id+
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", products=" + products +
                '}';
    }
}
