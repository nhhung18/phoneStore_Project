package com.vti.form;

public class updateCustomerForm {
    private String fullname;
    private String address;
    private Integer phone_num;

    public updateCustomerForm() {
        super();
    }

    public updateCustomerForm(String fullname, String address, int phone_num) {
        this.fullname = fullname;
        this.address = address;
        this.phone_num = phone_num;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public void setPhoneNum(Integer phoneNum) {
        this.phone_num = phone_num;
    }
}
