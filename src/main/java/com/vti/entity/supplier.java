package com.vti.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "supplieres", catalog = "phone_store")
public class supplier implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short supplierId;

    @Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
    private String email;

    @Column(name = "name", length = 50, nullable = false, unique = true, updatable = false)
    private String name;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "phone_num", nullable = false, unique = true)
    private int phoneNum;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    public supplier() {
        super();
    }

    public short getId() {
        return supplierId;
    }

    public void setId(short id) {
        this.supplierId = id;
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
