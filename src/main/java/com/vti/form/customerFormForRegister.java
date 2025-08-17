package com.vti.form;

import com.vti.entity.customer;
import com.vti.entity.role;

public class customerFormForRegister {
    private String email;
    private String username;
    private String fullname;
    private String address;
    private Integer phone_num;
    private String password;
    private com.vti.entity.role role = com.vti.entity.role.user;

    public customerFormForRegister() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public customerFormForRegister(String email, String username, String fullname, String address, Integer phone_num, String password) {
        this.email = email;
        this.username = username;
        this.fullname = fullname;
        this.address = address;
        this.phone_num = phone_num;
        this.password = password;
    }

    public customer asCustomer(){
        customer customer = new customer();
        customer.setEmail(email);
        customer.setUsername(username);
        customer.setFullname(fullname);
        customer.setAddress(address);
        customer.setPhone_num(phone_num);
        customer.setPassword(password);
        return customer;
    }

    public com.vti.entity.role getRole() {
        return role;
    }

    public void setRole(com.vti.entity.role role) {
        this.role = role;
    }
}
