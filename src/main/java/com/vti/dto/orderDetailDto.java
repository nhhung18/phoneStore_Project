package com.vti.dto;

import com.vti.entity.customer;
import com.vti.entity.order;
import com.vti.entity.product;

import java.math.BigDecimal;

public class orderDetailDto {
    private short id;
    private order order_id;
    private product product_id;
    private short quantity;
    private BigDecimal price;
    private BigDecimal total_price;

    public orderDetailDto() {
    }

    public orderDetailDto(short id, order order_id, product product_id, short quantity, BigDecimal price, BigDecimal total_price) {
        this.id = id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.total_price = total_price;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public order getOrder_id() {
        return order_id;
    }

    public void setOrder_id(order orderId) {
        this.order_id = orderId;
    }

    public product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(product product_id) {
        this.product_id = product_id;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }
}
