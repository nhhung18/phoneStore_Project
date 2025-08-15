package com.vti.dto;

import java.util.Date;

public class customerDto {
    private short id;
    private String email;
    private String username;
    private String fullname;
    private String address;
    private int phoneNum;
    private Date createDate;

    public customerDto() {
        super();
    }

    public customerDto(short id, String email, String username, String fullname, String address, int phoneNum, Date createDate) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.fullname = fullname;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
