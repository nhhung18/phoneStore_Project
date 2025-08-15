package com.vti.form;

public class updateSupplierForm {
    private String address;
    private Integer phone_num;

    public updateSupplierForm() {
        super();
    }

    public updateSupplierForm(String address, Integer phone_num) {
        this.address = address;
        this.phone_num = phone_num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(Integer phone_num) {
        this.phone_num = phone_num;
    }
}
