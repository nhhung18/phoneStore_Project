package com.vti.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
@Entity
@Table(name = "product", catalog = "phone_store")
public class product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short productId;

    @Column(name = "`name`", length = 50, nullable = false, unique = true, updatable = false)
    private String name;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "stock_quantity", columnDefinition = "INT UNSIGNED")
    private int stockQuantity;

    @Column(name = "capacity")
    @Enumerated(EnumType.STRING)
    private capacity capacity;

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private color color;


    public product() {
        super();
    }


    public short getId() {
        return productId;
    }

    public void setId(short id) {
        this.productId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stock_quantity) {
        this.stockQuantity = stock_quantity;
    }

    public com.vti.entity.capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(com.vti.entity.capacity capacity) {
        this.capacity = capacity;
    }

    public com.vti.entity.color getColor() {
        return color;
    }

    public void setColor(com.vti.entity.color color) {
        this.color = color;
    }
}
