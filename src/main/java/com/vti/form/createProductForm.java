package com.vti.form;

import java.math.BigDecimal;

public class createProductForm {
    private String name;
    private BigDecimal price;
    private Integer stock_quantity;
    private com.vti.entity.capacity capacity;
    private com.vti.entity.color color;


    public createProductForm() {
        super();
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

    public Integer getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(Integer stock_quantity) {
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


