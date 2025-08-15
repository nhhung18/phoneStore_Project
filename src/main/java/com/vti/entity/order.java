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
    private short order_id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, updatable = false)
    private customer customer_id;

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

    @OneToMany(mappedBy = "order_id")
    List<orderDetail> ordersDetails;

    public order() {
        super();
    }

    public short getOrder_id() {
        return order_id;
    }

    public void setOrder_id(short orderId) {
        this.order_id = orderId;
    }

    public customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(customer customerId) {
        this.customer_id = customerId;
    }

    public Date getCreateDate() {
        return orderDate;
    }

    public void setCreateDate(Date createDate) {
        this.orderDate = createDate;
    }

    public com.vti.entity.payingStatus getPaying_status() {
        return payingStatus;
    }

    public void setPaying_status(com.vti.entity.payingStatus payingStatus) {
        this.payingStatus = payingStatus;
    }

    public com.vti.entity.shipStatus getShip_status() {
        return shipStatus;
    }

    public void setShip_status(com.vti.entity.shipStatus shipStatus) {
        this.shipStatus = shipStatus;
    }
}
