package com.vti.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order", catalog = "phone_store")
public class order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, updatable = false)
    private customer customerId;

    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date orderDate;

    @Column(name = "paying_status")
//  cách lưu và hiển thị ENUM ra dưới dạng STRING
    @Enumerated(EnumType.STRING)
    private payingStatus payingStatus;

    @Column(name = "ship_status")
    @Enumerated(EnumType.STRING)
    private shipStatus shipStatus;

    @OneToMany(mappedBy = "order")
    List<orderDetail> ordersDetails;

    public order() {
        super();
    }

    public short getOrderId() {
        return orderId;
    }

    public void setOrderId(short orderId) {
        this.orderId = orderId;
    }

    public customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(customer customerId) {
        this.customerId = customerId;
    }

    public Date getCreateDate() {
        return orderDate;
    }

    public void setCreateDate(Date createDate) {
        this.orderDate = createDate;
    }

    public com.vti.entity.payingStatus getPayingStatus() {
        return payingStatus;
    }

    public void setPayingStatus(com.vti.entity.payingStatus payingStatus) {
        this.payingStatus = payingStatus;
    }

    public com.vti.entity.shipStatus getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(com.vti.entity.shipStatus shipStatus) {
        this.shipStatus = shipStatus;
    }
}
