package com.vti.dto;

import com.vti.entity.customer;
import com.vti.entity.payingStatus;
import com.vti.entity.shipStatus;

import java.util.Date;

public class orderDto {
    private short id;
    private customer customer_id;
    private Date orderDate;
    private payingStatus payingStatus;
    private shipStatus shipStatus;

    public orderDto(short id, customer customer_id, Date orderDate, com.vti.entity.payingStatus payingStatus, com.vti.entity.shipStatus shipStatus) {
        this.id = id;
        this.customer_id = customer_id;
        this.orderDate = orderDate;
        this.payingStatus = payingStatus;
        this.shipStatus = shipStatus;
    }

    public orderDto() {
        super();
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(customer customer_id) {
        this.customer_id = customer_id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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
