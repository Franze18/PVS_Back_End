package com.pvsbackend.pvs.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    private @Id
    @GeneratedValue Long id;
    private String productName;
    private double price;

    Product (){}
    
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;

    }

    //getters
    

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    //setters
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
