package com.vti.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer", catalog = "phone_store")
public class customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short customerId;

    @Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
    private String email;

    @Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "Fullname", length = 50, nullable = false)
    private String fullname;

    @Column(name = "Address", length = 100, nullable = false)
    private String andress;

    @Column(name = "phone_num", nullable = false, unique = true)
    private int phoneNum;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @OneToMany(mappedBy = "customerId")
    List<order> orders;


    public customer() {
        super();
    }

    public short getId() {
        return customerId;
    }

    public void setId(short id) {
        this.customerId = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAndress() {
        return andress;
    }

    public void setAndress(String andress) {
        this.andress = andress;
    }

    public int getPhone_num() {
        return phoneNum;
    }

    public void setPhone_num(int phone_num) {
        this.phoneNum = phone_num;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
