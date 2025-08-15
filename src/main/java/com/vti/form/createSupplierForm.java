package com.vti.form;

public class createSupplierForm {
    private String email;
    private String name;
    private String address;
    private Integer phone_num;

    public createSupplierForm() {
        super();
    }

    public createSupplierForm(String email, String name, String address, Integer phone_num) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.phone_num = phone_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
