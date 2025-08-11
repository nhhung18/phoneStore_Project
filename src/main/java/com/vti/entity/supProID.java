package com.vti.entity;

import jakarta.persistence.*;

import java.io.Serializable;

// Gần như @ID để đại diện cho 2 biến primary key
@Embeddable
public class supProID implements Serializable {
    private short supplierId;
    private short productId;

    public short getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(short supplierId) {
        this.supplierId = supplierId;
    }

    public short getProductId() {
        return productId;
    }

    public void setProductId(short productId) {
        this.productId = productId;
    }
}
