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
    private order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private product product;

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

    public com.vti.entity.order getOrder() {
        return order;
    }

    public void setOrder(com.vti.entity.order order) {
        this.order = order;
    }

    public com.vti.entity.product getProduct() {
        return product;
    }

    public void setProduct(com.vti.entity.product product) {
        this.product = product;
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
