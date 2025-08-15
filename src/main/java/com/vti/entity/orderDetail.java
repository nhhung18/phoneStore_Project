package com.vti.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "order_detail", catalog = "phone_store")
public class orderDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short orderDetailId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private order order_id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private product product_id;

    @Column(name = "quantity")
    private short quantity;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice;

    public orderDetail() {
        super();
    }

    public short getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(short orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public com.vti.entity.order getOrder_id() {
        return order_id;
    }

    public void setOrder_id(com.vti.entity.order order_id) {
        this.order_id = order_id;
    }

    public com.vti.entity.product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(com.vti.entity.product product) {
        this.product_id = product;
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
        return totalPrice;
    }

    public void setTotal_price(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
