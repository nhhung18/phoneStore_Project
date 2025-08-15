package com.vti.form;

import com.vti.entity.payingStatus;
import com.vti.entity.shipStatus;

public class updateOrderForm {
    private payingStatus paying_status;
    private shipStatus ship_status;

    public updateOrderForm() {
        super();
    }

    public updateOrderForm(payingStatus paying_status, shipStatus ship_status) {
        this.paying_status = paying_status;
        this.ship_status = ship_status;
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
