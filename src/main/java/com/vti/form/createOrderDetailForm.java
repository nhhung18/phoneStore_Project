package com.vti.form;

import com.vti.entity.order;
import com.vti.entity.product;

public class createOrderDetailForm {
    private order order_id;
    private product product_id;
    private short quantity;

    public createOrderDetailForm(order order_id, product product_id, short quantity) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public order getOrder_id() {
        return order_id;
    }

    public void setOrder_id(order order_id) {
        this.order_id = order_id;
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
}
