package com.vti.dto;

import com.vti.entity.capacity;
import com.vti.entity.color;

import java.math.BigDecimal;

public class productDto {
    private short id;
    private String name;
    private BigDecimal price;
    private int stock_quantity;
    private capacity capacity;
    private color color;


    public productDto(short id, String name, BigDecimal price, int stock_quantity, com.vti.entity.capacity capacity, com.vti.entity.color color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.capacity = capacity;
        this.color = color;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
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

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
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
