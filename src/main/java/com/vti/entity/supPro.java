package com.vti.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "supplieres_product", catalog = "phone_store")
public class supPro {

//    Dành cho dữ liệu có 2 khóa chính
    @EmbeddedId
    private supProID id; // Dùng class khóa phức hợp

    @ManyToOne
    @MapsId("supplierId") // ánh xạ supplierId trong id
    @JoinColumn(name = "suppliers_id", nullable = false, updatable = false)
    private supplier supplier;

    @ManyToOne
    @MapsId("productId") // ánh xạ productId trong id
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    private product product;

    public supPro() {
        super();
    }

    public supProID getId() {
        return id;
    }

    public void setId(supProID id) {
        this.id = id;
    }

    public com.vti.entity.supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(com.vti.entity.supplier supplier) {
        this.supplier = supplier;
    }

    public com.vti.entity.product getProduct() {
        return product;
    }

    public void setProduct(com.vti.entity.product product) {
        this.product = product;
    }
}
