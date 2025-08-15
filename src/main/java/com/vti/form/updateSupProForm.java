package com.vti.form;

import com.vti.entity.product;
import com.vti.entity.supProID;

public class updateSupProForm {
    private product product_id;

    public updateSupProForm() {
        super();
    }

    public updateSupProForm(product product_id) {
        this.product_id = product_id;
    }

    public product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(product product_id) {
        this.product_id = product_id;
    }
}
