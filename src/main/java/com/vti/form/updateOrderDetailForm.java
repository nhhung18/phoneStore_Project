package com.vti.form;

import com.vti.entity.order;
import com.vti.entity.product;

public class updateOrderDetailForm {
    private order order_id;
    private product product_id;
    private Short quantity;

    public updateOrderDetailForm(order order_id, product product_id, Short quantity) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public updateOrderDetailForm() {
        super();
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

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }
}
