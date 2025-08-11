package com.vti.dto;

import com.vti.entity.product;
import com.vti.entity.supplier;

public class supProDto {
    private supplier suppliers_id;
    private product product_id;

    public supProDto(supplier suppliers_id, product product_id) {
        this.suppliers_id = suppliers_id;
        this.product_id = product_id;
    }

    public supplier getSuppliers_id() {
        return suppliers_id;
    }

    public void setSuppliers_id(supplier suppliers_id) {
        this.suppliers_id = suppliers_id;
    }

    public product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(product product_id) {
        this.product_id = product_id;
    }
}
