package com.vti.form;

import com.vti.entity.customer;
import com.vti.entity.payingStatus;
import com.vti.entity.shipStatus;

public class createOrderForm {
    private customer customer_id;
    private payingStatus paying_status;
    private shipStatus ship_status;

    public createOrderForm() {
        super();
    }

    public createOrderForm(customer customer_id, payingStatus paying_status, shipStatus ship_status) {
        this.customer_id = customer_id;
        this.paying_status = paying_status;
        this.ship_status = ship_status;
    }

    public customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(customer customer_id) {
        this.customer_id = customer_id;
    }

    public payingStatus getPaying_status() {
        return paying_status;
    }

    public void setPaying_status(payingStatus paying_status) {
        this.paying_status = paying_status;
    }

    public shipStatus getShip_status() {
        return ship_status;
    }

    public void setShip_status(shipStatus ship_status) {
        this.ship_status = ship_status;
    }
}
