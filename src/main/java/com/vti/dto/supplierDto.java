package com.vti.dto;

import java.util.Date;

public class supplierDto {
    private short id;
    private String email;
    private String name;
    private String address;
    private int phoneNum;
    private Date createDate;

    public supplierDto(short id, String email, String name, String address, int phoneNum, Date createDate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.createDate = createDate;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public supplierDto() {
        super();
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

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
