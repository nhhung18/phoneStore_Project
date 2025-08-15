package com.vti.form;

public class createCustomerForm {
    private String email;
    private String username;
    private String fullname;
    private String address;
    private Integer phone_num;

    public createCustomerForm() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setPhone_num(Integer phone_Num) {
        this.phone_num = phone_Num;
    }

    public createCustomerForm(String email, String username, String fullname, String address, Integer phone_num) {
        this.email = email;
        this.username = username;
        this.fullname = fullname;
        this.address = address;
        this.phone_num = phone_num;
    }
}
